package com.oman.forward.wanandroid.net

import android.content.Context
import com.oman.forward.wanandroid.register.RegisterModuleImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient(private val context: Context) {

    companion object {
        private var instance: RetrofitClient? = null
        fun getInstance(context: Context): RetrofitClient {
            return instance ?: synchronized(this) {
                instance ?: RetrofitClient(context).also {
                    instance = it
                }
            }
        }
    }

    fun <T> create(clazz: Class<T>): T {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build()

        return Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(RegisterModuleImpl.BASE_URL)
                .build()
                .create(clazz)
    }
}