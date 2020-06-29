package com.oman.forward.wanandroid.register

import android.content.Context
import com.oman.forward.wanandroid.api.WanAndroidAPI
import com.oman.forward.wanandroid.entity.LoginRegisterResponse
import com.oman.forward.wanandroid.net.APIResponse
import com.oman.forward.wanandroid.register.inner.RegisterListener
import com.oman.forward.wanandroid.register.inner.RegisterModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RegisterModuleImpl : RegisterModule {
    override fun registerAction(context: Context,
                                username: String,
                                password: String,
                                rePassword: String,
                                registerListener: RegisterListener) {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
        retrofit.create(WanAndroidAPI::class.java)
                .registerAction(username, password, rePassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : APIResponse<LoginRegisterResponse>(context) {
                    override fun success(t: LoginRegisterResponse) {
                        registerListener.registerSuccess(t)
                    }

                    override fun failure(errorMsg: String?) {
                        registerListener.registerFailure(errorMsg)
                    }
                })
    }

    companion object {
        private const val baseUrl = "https://www.wanandroid.com"
    }

}