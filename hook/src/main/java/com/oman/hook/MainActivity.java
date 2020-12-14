package com.oman.hook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.Arrays;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CopyUtils.copy(this);
    }

    public void hookActivityInstrumentation(View view) {
        HookUtils.hookActivityInstrument(this);
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void hookActivityThreadInstrumentation(View view) {
        HookUtils.hookActivityThreadInstrument();
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getApplicationContext().startActivity(intent);
    }

    public void hookAMS(View view) {
        HookUtils.hookAMS();
        startActivity(new Intent(this, RegisterActivity.class));
    }

    public void startNoRegisterActivity(View view) {
        startActivity(new Intent(this, NoRegisterActivity.class));
    }

    /**
     * 想要启动插件apk中的Activity 需要解决以下问题:
     * 1 首先需要加载dex文件，不然找不到类
     * 2 然后需要hook AMS和 Handler
     * 3 然后是资源的加载需要处理
     *
     * @param view
     */
    public void startPluginApkActivity(View view) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.oman.pluginapk",
                "com.oman.pluginapk.MainActivity"));
        startActivity(intent);
    }
}
