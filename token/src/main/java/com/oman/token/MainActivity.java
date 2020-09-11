package com.oman.token;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    WanAndroidApi wanAndroidApi;

    private static final String BASE_URL = "https://www.wanandroid.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(new TokenInterceptor())
                .addInterceptor(new LogInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://www.wanandroid.com/")
                .build();

        WanAndroidApi api = retrofit.create(WanAndroidApi.class);

        wanAndroidApi = (WanAndroidApi) Proxy.newProxyInstance(this.getClassLoader(), new Class[]{WanAndroidApi.class}, new InvocationHandler() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                Token tokenAnnotation = method.getDeclaredAnnotation(Token.class);
                boolean needToken = tokenAnnotation != null && tokenAnnotation.value();
                String url = null;
                for (Annotation annotation : method.getDeclaredAnnotations()) {
                    if (annotation instanceof GET) {
                        url = ((GET) annotation).value();
                    } else if (annotation instanceof POST) {
                        url = ((POST) annotation).value();
                    }
                    //TODO 处理其它的请求类型，这里只是演示，只处理了GET POST请求
                }
                if (needToken)
                    TokenSets.INSTANCE.add(BASE_URL + url);
                return method.invoke(api, objects);
            }
        });
    }

    @SuppressLint("CheckResult")
    public void apiNotContainToken(View view) {
        wanAndroidApi.getBanner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bean>() {
                    @Override
                    public void accept(Bean bannerBean) {
                        Log.i("oman", "getBanner data: " + bannerBean.toString());
                    }
                });
    }

    @SuppressLint("CheckResult")
    public void apiContainToken(View view) {
        wanAndroidApi.getFriend()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Bean>() {
                    @Override
                    public void accept(Bean friendBean) {
                        Log.i("oman", "getFriend data: " + friendBean);
                    }
                });
    }
}
