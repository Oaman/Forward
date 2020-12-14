package com.oman.pluginapk;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;

import androidx.annotation.Nullable;

import java.lang.reflect.Field;

public class BaseActivity extends Activity {

    protected Context context;

    // 不会影响到宿主
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Resources resources = LoadUtils.getResources(getApplication());

        context = new ContextThemeWrapper(getBaseContext(), 0);
        Log.i("aaa", "plugin getBaseContext:" + getBaseContext() + "--getApplication():" + getApplication()
                + "--mContext:" + context + "--packageName:" + context.getPackageName());
        Class<? extends Context> clazz = context.getClass();
        try {
            Field mResourcesField = clazz.getDeclaredField("mResources");
            mResourcesField.setAccessible(true);
            mResourcesField.set(context, resources);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
