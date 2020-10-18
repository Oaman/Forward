package com.oman.webview.webviewprocess;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.oman.base.BaseApplication;
import com.oman.webview.IWebViewToMainCommand;
import com.oman.webview.mainprocess.MainProcessCommandManager;
import com.oman.webview.mainprocess.MainProcessCommandService;

import static android.content.Context.BIND_AUTO_CREATE;

public class WebViewCommandDispatcher implements ServiceConnection {

    private static WebViewCommandDispatcher sInstance;

    private IWebViewToMainCommand iWebViewToMainCommand;

    private WebViewCommandDispatcher() {
    }

    public static WebViewCommandDispatcher getInstance() {
        if (sInstance == null) {
            synchronized (WebViewCommandDispatcher.class) {
                if (sInstance == null) {
                    sInstance = new WebViewCommandDispatcher();
                }
            }
        }
        return sInstance;
    }

    void initAidl() {
        /**
         * 3 启动时候
         */
        Intent intent = new Intent(BaseApplication.sApplication, MainProcessCommandService.class);
        BaseApplication.sApplication.bindService(intent, this, BIND_AUTO_CREATE);
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        iWebViewToMainCommand = IWebViewToMainCommand.Stub.asInterface(service);
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
        iWebViewToMainCommand = null;
        initAidl();
    }

    @Override
    public void onBindingDied(ComponentName name) {
        iWebViewToMainCommand = null;
        initAidl();
    }

    void executeCommand(String commandName, String params) {
        /**
         * 此处不能用这个，因为这里属于跨进程通信，需要用到aidl接口 + MainProcessCommandService需要注册
         */
        try {
//            MainProcessCommandManager.getInstance().handCommand(commandName, params);
            iWebViewToMainCommand.handCommand(commandName, params);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
