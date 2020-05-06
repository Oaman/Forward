package com.oman.forward.study.dynamicLoad;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * @author:ZhouJiang
 * @date:2020/5/6 22:18
 * @email:zhoujiang2012@163.com
 */
public class InstrumentationProxy extends Instrumentation {
    private Instrumentation mInstrumentation;

    public InstrumentationProxy(Instrumentation instrumentation) {
        mInstrumentation = instrumentation;
    }

    public ActivityResult execStartActivity(
            Context who, IBinder contextThread, IBinder token, Activity target,
            Intent intent, int requestCode, Bundle options) {
        Log.i("aaa", "Hook success: who:"+who);
        try {
            Method execStartActivity = Instrumentation.class.getDeclaredMethod("execStartActivity", Context.class, IBinder.class
                    , IBinder.class, Activity.class, Intent.class, int.class, Bundle.class);
            return (ActivityResult) execStartActivity.invoke(mInstrumentation, who, contextThread, token, target, intent, requestCode, options);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
