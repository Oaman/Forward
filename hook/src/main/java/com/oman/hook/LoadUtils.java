package com.oman.hook;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import dalvik.system.DexClassLoader;

public class LoadUtils {
    private final static String apkPath = "/sdcard/pluginapk-debug.apk";

    public static void load(Context context) {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
