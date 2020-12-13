package com.oman.hook;

import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LoadUtils.load(this);
        HookUtils.hookAMSNoRegister();
        HookUtils.hookH();
    }
}
