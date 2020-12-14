package com.oman.hook;

import android.app.Application;

import java.io.File;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        LoadUtils.loadDexWithNewClassLoader(this);
        LoadUtils.loadDexWithReflectMakeElements(this);
        HookUtils.hookAMSNoRegister();
        HookUtils.hookH();
    }
}
