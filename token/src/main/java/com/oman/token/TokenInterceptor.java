package com.oman.token;

import android.util.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

public class TokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        String url = chain.request().url().toString();
        if (TokenSets.INSTANCE.contains(url)) {
            Log.i("aaa", "intercept need add token: " + url);
            return chain.proceed(chain.request().newBuilder().url(
                    chain.request().url().newBuilder().addQueryParameter("token", "asdf").build()).build());
        } else {
            return chain.proceed(chain.request());
        }
    }
}
