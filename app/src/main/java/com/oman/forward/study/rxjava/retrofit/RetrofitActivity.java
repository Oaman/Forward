package com.oman.forward.study.rxjava.retrofit;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.oman.forward.R;
import com.oman.forward.study.rxjava.self.RetrofitSelf;
import com.oman.forward.study.rxjava.self.RetrofitSelfApi;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * @author:ZhouJiang
 * @date:2020/5/27 21:07
 * @email:zhoujiang2012@163.com
 */
public class RetrofitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://restapi.amap.com")
                .build();

        //使用Retrofit
        retrofit.create(RetrofitApi.class).getWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b")
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(@NotNull Call<ResponseBody> call, @NotNull Response<ResponseBody> response) {
                        try {
                            Log.i("aaa", "response: " + response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.i("aaa", "exception: " + t);
                    }
                });

        RetrofitSelf self = new RetrofitSelf.Builder().baseUrl("http://restapi.amap.com").build();
        self.create(RetrofitSelfApi.class).getWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b")
                .enqueue(new okhttp3.Callback() {
                    @Override
                    public void onResponse(okhttp3.Call call, okhttp3.Response response) {
                        try {
                            Log.i("aaa", "self get response: " + response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(okhttp3.Call call, IOException t) {
                        Log.i("aaa", "self exception: " + t);
                    }
                });

        self.create(RetrofitSelfApi.class).postWeather("110101", "ae6c53e2186f33bbf240a12d80672d1b")
                .enqueue(new okhttp3.Callback() {
                    @Override
                    public void onResponse(okhttp3.Call call, okhttp3.Response response) {
                        try {
                            Log.i("aaa", "self post response: " + response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(okhttp3.Call call, IOException t) {
                        Log.i("aaa", "self exception: " + t);
                    }
                });
    }
}
