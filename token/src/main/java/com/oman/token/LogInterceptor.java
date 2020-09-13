package com.oman.token;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class LogInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.i("aaa", "intercept: url:" + chain.request().url().toString());
        return chain.proceed(chain.request());
    }
}
