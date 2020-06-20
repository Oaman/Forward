package com.oman.hook;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class HookUtils {
    /**
     * 1 静态的可以直接field.get(null)获取  比如ActivityThread中的sCurrentActivityThread
     * 2 可以通过字段或者方法获取字段的 比如比如ActivityThread中的CurrentActivityThread
     *
     * @param activity
     */
    public static void hookActivityInstrument(Activity activity) {
        try {
            //hook Activity中的 mInstrumentation
            Field mInstrumentationField = Activity.class.getDeclaredField("mInstrumentation");
            mInstrumentationField.setAccessible(true);
            Instrumentation instrumentation = (Instrumentation) mInstrumentationField.get(activity);
            ProxyInstrumentation proxyInstrumentation = new ProxyInstrumentation(instrumentation);
            mInstrumentationField.set(activity, proxyInstrumentation);
        } catch (Exception e) {
            Log.i("aaa", "exception--hookActivityInstrument:" + e);
            e.printStackTrace();
        }
    }

    private static class ProxyInstrumentation extends Instrumentation {

        private Instrumentation mInstrumentation;

        public ProxyInstrumentation(Instrumentation instrumentation) {
            this.mInstrumentation = instrumentation;
        }

        public ActivityResult execStartActivity(
                Context who, IBinder contextThread, IBinder token, Activity target,
                Intent intent, int requestCode, Bundle options) {

            Log.d("aaa", "执行了startActivity, 参数如下: " + "who = [" + who + "], " +
                    "contextThread = [" + contextThread + "], token = [" + token + "], " +
                    "target = [" + target + "], intent = [" + intent +
                    "], requestCode = [" + requestCode + "], options = [" + options + "]");

            try {
                Method execStartActivity = mInstrumentation.getClass().getDeclaredMethod("execStartActivity", Context.class, IBinder.class,
                        IBinder.class, Activity.class, Intent.class, int.class, Bundle.class);
                return (ActivityResult) execStartActivity.invoke(mInstrumentation, who, contextThread, token, target, intent, requestCode, options);
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        @Override
        public Activity newActivity(ClassLoader cl, String className, Intent intent)
                throws ClassNotFoundException, IllegalAccessException, InstantiationException {
            return mInstrumentation.newActivity(cl, className, intent);
        }
    }

    public static void hookActivityThreadInstrument() {
        try {
            Class<?> classActivityThread = Class.forName("android.app.ActivityThread");
            //hook 方法currentActivityThread
//            Method currentActivityThreadMethod = classActivityThread.getDeclaredMethod("currentActivityThread");
//            currentActivityThreadMethod.setAccessible(true);
//            Object sCurrentActivityThread = currentActivityThreadMethod.invoke(null);

            //hook 字段mCurrentActivityThread
            Field sCurrentActivityThreadField = classActivityThread.getDeclaredField("sCurrentActivityThread");
            sCurrentActivityThreadField.setAccessible(true);
            Object sCurrentActivityThread = sCurrentActivityThreadField.get(null);

            //获取mInstrumentation字段, 然后设置代理对象
            Field mInstrumentationField = classActivityThread.getDeclaredField("mInstrumentation");
            mInstrumentationField.setAccessible(true);
            Instrumentation instrumentation = (Instrumentation) mInstrumentationField.get(sCurrentActivityThread);
            ProxyInstrumentation proxyInstrumentation = new ProxyInstrumentation(instrumentation);
            mInstrumentationField.set(sCurrentActivityThread, proxyInstrumentation);
        } catch (Exception e) {
            Log.i("aaa", "exception--hookActivityThreadInstrument:" + e);
            e.printStackTrace();
        }
    }


    public static void hookAMS() {
        try {
            //针对7.0以下和8.0以上分别处理
            Field singletonField;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Class<?> classActivityManagerNative = Class.forName("android.app.ActivityManager");
                singletonField = classActivityManagerNative.getDeclaredField("IActivityManagerSingleton");
            } else {
                Class<?> classActivityManager = Class.forName("android.app.ActivityManagerNative");
                singletonField = classActivityManager.getDeclaredField("gDefault");
            }
            singletonField.setAccessible(true);
            Object singleton = singletonField.get(null);

            Class<?> classSingleton = Class.forName("android.util.Singleton");
            Field mInstanceField = classSingleton.getDeclaredField("mInstance");
            mInstanceField.setAccessible(true);
            Object activityManager = mInstanceField.get(singleton);

            Class<?> classIActivityManager = Class.forName("android.app.IActivityManager");
            Object proxyInstance = Proxy.newProxyInstance(classSingleton.getClassLoader(), new Class[]{classIActivityManager}, new InvocationHandler() {
                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if ("startActivity".equals(method.getName())) {
                        for (Object o : args) {
                            Log.i("aaa", "AMS invoke:" + o);
                        }
                    }
                    return method.invoke(activityManager, args);
                }
            });
            mInstanceField.set(singleton, proxyInstance);
        } catch (Exception e) {
            Log.i("aaa", "exception--hookAMS:" + e);
            e.printStackTrace();
        }
    }

    public static void hookAMSNoRegister() {
        try {
            Field singletonField;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                Class<?> classActivityManagerNative = Class.forName("android.app.ActivityManager");
                singletonField = classActivityManagerNative.getDeclaredField("IActivityManagerSingleton");
            } else {
                Class<?> classActivityManager = Class.forName("android.app.ActivityManagerNative");
                singletonField = classActivityManager.getDeclaredField("gDefault");
            }
            singletonField.setAccessible(true);
            Object singleton = singletonField.get(null);

            Class<?> classSingleton = Class.forName("android.util.Singleton");
            Field mInstanceField = classSingleton.getDeclaredField("mInstance");
            mInstanceField.setAccessible(true);
            Object activityManager = mInstanceField.get(singleton);

            Class<?> classIActivityManager = Class.forName("android.app.IActivityManager");
            Object proxyInstance = Proxy.newProxyInstance(classSingleton.getClassLoader(), new Class[]{classIActivityManager},
                    new NoRegisterInvocationHandler(activityManager));
            mInstanceField.set(singleton, proxyInstance);
        } catch (Exception e) {
            Log.i("aaa", "exception--hookAMS:" + e);
            e.printStackTrace();
        }
    }

    private static class NoRegisterInvocationHandler implements InvocationHandler {
        private Object mObject;

        public NoRegisterInvocationHandler(Object mObject) {
            this.mObject = mObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("startActivity".equals(method.getName())) {
                int index = 0;
                for (int i = 0, length = args.length; i < length; i++) {
                    if (args[i] instanceof Intent) {
                        index = i;
                        break;
                    }
                }
                Intent noRegisterIntent = (Intent) args[index];
                Log.i("aaa", "threadName:" + Thread.currentThread().getName() + "--intent invoke:" + noRegisterIntent);
                //获取register的intent代替没有注册的activity，达到欺骗AMS的目的，使得运行时候不会因为没有注册而报错
                Intent registerIntent = new Intent();
                ComponentName componentName = new ComponentName("com.oman.hook", RegisterActivity.class.getName());
                registerIntent.setComponent(componentName);
                registerIntent.putExtra("target_activity", noRegisterIntent);
                args[index] = registerIntent;
            }
            return method.invoke(mObject, args);
        }
    }


    public static void hookH() {
        try {
            Class<?> classActivityThread = Class.forName("android.app.ActivityThread");
            //获取currentActivityThread
            Field sCurrentActivityThreadField = classActivityThread.getDeclaredField("sCurrentActivityThread");
            sCurrentActivityThreadField.setAccessible(true);
            Object sCurrentActivityThread = sCurrentActivityThreadField.get(null);

            //获取H对象
            Field mHField = classActivityThread.getDeclaredField("mH");
            mHField.setAccessible(true);
            Handler mH = (Handler) mHField.get(sCurrentActivityThread);

            Field mCallbackField = Handler.class.getDeclaredField("mCallback");
            mCallbackField.setAccessible(true);
            mCallbackField.set(mH, new NoRegisterActivityHandler(mH));

        } catch (Exception e) {
            Log.i("aaa", "threadName:" + Thread.currentThread().getName() + "hookH:" + e);
            e.printStackTrace();
        }
    }

    private static class NoRegisterActivityHandler implements Handler.Callback {
        private Handler mHandler;

        public NoRegisterActivityHandler(Handler mHandler) {
            this.mHandler = mHandler;
        }

        @Override
        public boolean handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                //android P(不含P 9.0) 之前
                // ActivityThread里面 "LAUNCH_ACTIVITY" 这个字段的值是100
                // 本来使用反射的方式获取最好, 这里为了简便直接使用硬编码
                // 在H类中，定义了几十种消息，比如说LAUNCH_ACTIVITY的值是100，PAUSE_ACTIVITY的值是101。从100到109，都是给Activity的生命周期函数准备的
                //LAUNCH_ACTIVITY = 100
                case 100:
                    handleLaunchActivity(msg);
                    break;
                //EXECUTE_TRANSACTION = 159
                case 159:
                    handleActivity(msg);
                    break;//EXECUTE_TRANSACTION
            }
            mHandler.handleMessage(msg);
            return true;
        }

        private void handleLaunchActivity(Message msg) {
            try {
                Object o = msg.obj;
                //获取真实的想要启动的没有注册的intent, 用其替换原来的intent, 就是把替身恢复成真身
                Field intentField = o.getClass().getDeclaredField("intent");
                intentField.setAccessible(true);
                Intent registerIntent = (Intent) intentField.get(o);
                Intent noRegisterIntent = registerIntent.getParcelableExtra("target_activity");
                registerIntent.setComponent(noRegisterIntent.getComponent());
            } catch (Exception e) {
                Log.i("aaa", "threadName:" + Thread.currentThread().getName() + "--handleLaunchActivity:" + e);
                e.printStackTrace();
            }
        }

        private void handleActivity(Message msg) {
            try {
                Object obj = msg.obj;
                Field mActivityCallbacksField = obj.getClass().getDeclaredField("mActivityCallbacks");
                mActivityCallbacksField.setAccessible(true);
                List<Object> mActivityCallbacks = (List<Object>) mActivityCallbacksField.get(obj);

                if (mActivityCallbacks.size() > 0) {
                    String className = "android.app.servertransaction.LaunchActivityItem";
                    if (mActivityCallbacks.get(0).getClass().getCanonicalName().equals(className)) {
                        Object object = mActivityCallbacks.get(0);
                        Field intentField = object.getClass().getDeclaredField("mIntent");
                        intentField.setAccessible(true);
                        Intent intent = (Intent) intentField.get(object);
                        Intent target = intent.getParcelableExtra("target_activity");
                        intent.setComponent(target.getComponent());
                    }
                }
            } catch (Exception e) {
                Log.e("aaa", "handleActivity: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
