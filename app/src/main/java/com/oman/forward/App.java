package com.oman.forward;

import com.kingja.loadsir.core.LoadSir;
import com.oman.base.BaseApplication;
import com.oman.base.loadsir.CustomCallback;
import com.oman.base.loadsir.EmptyCallback;
import com.oman.base.loadsir.ErrorCallback;
import com.oman.base.loadsir.LoadingCallback;
import com.oman.base.loadsir.TimeoutCallback;

public class App extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        LoadSir.beginBuilder()
                .addCallback(new ErrorCallback())
                .addCallback(new EmptyCallback())
                .addCallback(new LoadingCallback())
                .addCallback(new TimeoutCallback())
                .addCallback(new CustomCallback())
                .setDefaultCallback(LoadingCallback.class)
                .commit();
    }
}
