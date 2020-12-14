package com.oman.hook;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import dalvik.system.DexClassLoader;

public class LoadUtils {
    public final static String apkPath = "/sdcard/pluginapk-debug.apk";

    /**
     * 使用new DexClassLoader的方式来获取插件的dexElements
     */
    public static void loadDexWithNewClassLoader(Context context) {
        try {
            // TODO 1 先要获取BaseDexClassLoader中的field PathList和DexPathList中的field dexElements，方便后面宿主和插件获取对象使用
            Class<?> clazzBaseDexClassLoader = Class.forName("dalvik.system.BaseDexClassLoader");
            Field pathListField = clazzBaseDexClassLoader.getDeclaredField("pathList");
            pathListField.setAccessible(true);

            Class<?> clazzDexPathList = Class.forName("dalvik.system.DexPathList");
            Field dexElementsField = clazzDexPathList.getDeclaredField("dexElements");
            dexElementsField.setAccessible(true);

            // TODO 2 获取宿主的dexElements对象
            ClassLoader hostClassLoader = context.getClassLoader();
            Object hostDexPathListObj = pathListField.get(hostClassLoader);
            Object[] hostDexElementsObj = (Object[]) dexElementsField.get(hostDexPathListObj);

            // TODO 3 获取插件的dexElements对象
            DexClassLoader dexClassLoader = new DexClassLoader(apkPath, context.getCacheDir().getAbsolutePath(),
                    null, context.getClassLoader());
            Object pluginDexPathListObj = pathListField.get(dexClassLoader);
            Object[] pluginDexElementsObj = (Object[]) dexElementsField.get(pluginDexPathListObj);

            // TODO 4 将宿主和插件合成为新的dexElements对象
            Object[] newDexElements = (Object[]) Array.newInstance(hostDexElementsObj.getClass().getComponentType(),
                    hostDexElementsObj.length + pluginDexElementsObj.length);
            System.arraycopy(hostDexElementsObj, 0, newDexElements, 0, hostDexElementsObj.length);
            System.arraycopy(pluginDexElementsObj, 0, newDexElements, hostDexElementsObj.length, pluginDexElementsObj.length);

            // TODO 5 将新的dexElements赋值给宿主的fieldDexElements字段
            dexElementsField.set(hostDexPathListObj, newDexElements);
            Log.i("aaa", "loadDexWithNewClassLoader");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 使用反射调用DexPathList中的makeElements的方式来生成插件的dexElements 这种比较上面的好的地方是兼容性更强
     * 1
     */
    public static void loadDexWithReflectMakeElements(Application application) {
        try {
            // TODO 1 反射获取字段
            Class<?> clazzBaseDexClassLoader = Class.forName("dalvik.system.BaseDexClassLoader");
            Field pathListField = clazzBaseDexClassLoader.getDeclaredField("pathList");
            pathListField.setAccessible(true);

            Class<?> clazzDexPathList = Class.forName("dalvik.system.DexPathList");
            Field dexElementsField = clazzDexPathList.getDeclaredField("dexElements");
            dexElementsField.setAccessible(true);

            // TODO 2 获取宿主的dexElements
            ClassLoader pathClassLoader = application.getClassLoader();
            Object pathListObj = pathListField.get(pathClassLoader);

            Object[] hostDexElementsObj = (Object[]) dexElementsField.get(pathListObj);

            // TODO 3 使用反射的方法调用makeElements  获取插件的dexElements
            //  这里有个兼容性问题，makePathElements或者makeDexElements
            //  另外因为在android N上有混合编译的影响会影响类修复，所以在tinker中会做兼容处理，大于7的话需要创建自定义的classLoader替换pathClassLoader
            //  Android N使用混合模式的运行时。应用在安装时不做编译，而是运行时解释字节码，同时在JIT编译了一
            //  些代码后将这些代码信息记录至 Profile文件，等到设备空闲的时候使用AOT(All-Of-the-Time compilation:全
            //  时段编译)编译生成称为 app_image的 base.art( 类对象映像) )文件，这个art文件会在apk启动时自动加载（相当
            //  于缓存）。根据类加载原理，类被加载了无法被替换，即无法修复
            //  10.0只是限制黑名单不能反射，其它的不受影响；比如浅灰的可以
            //  另外在低版本（davlik虚拟机）也有一个兼容性问题 就是CLASS_ISPREVERIFIED 如果我们的MainActivity中只引用了本dex的类，就会被打上这个标签，在修复的时候引用了其它的dex中的类替换本dex的类的时候，就会报错
            //  所以需要字节码插桩，让类引用其它dex中的类，就不会被打上标签，就能修复成功
            Object[] pluginDexElementsObj = null;
            List<File> files = new ArrayList<>();
            files.add(new File(apkPath));
            List<IOException> ioExceptions = new ArrayList<>();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                Method makePathElementsMethod = clazzDexPathList.getDeclaredMethod(
                        "makePathElements", List.class, File.class, List.class);
                makePathElementsMethod.setAccessible(true);
                Log.i("aaa", "enter makePathElements");
                pluginDexElementsObj = (Object[]) makePathElementsMethod.invoke(pathListObj, files, application.getCacheDir(), ioExceptions);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                Method makePathElementsMethod = clazzDexPathList.getDeclaredMethod(
                        "makeDexElements", ArrayList.class, File.class, ArrayList.class);
                makePathElementsMethod.setAccessible(true);
                Log.i("aaa", "enter makeDexElements");
                pluginDexElementsObj = (Object[]) makePathElementsMethod.invoke(pathListObj, files, application.getCacheDir(), ioExceptions);
            }

            // TODO 4 将宿主和插件合成为新的dexElements对象
            Object[] newDexElements = (Object[]) Array.newInstance(hostDexElementsObj.getClass().getComponentType(),
                    hostDexElementsObj.length + pluginDexElementsObj.length);
            System.arraycopy(hostDexElementsObj, 0, newDexElements, 0, hostDexElementsObj.length);
            System.arraycopy(pluginDexElementsObj, 0, newDexElements, hostDexElementsObj.length, pluginDexElementsObj.length);

            // TODO 5 将新的dexElements赋值给宿主的fieldDexElements字段
            dexElementsField.set(pathListObj, newDexElements);
            Log.i("aaa", "loadDexWithReflectMakeElements");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
