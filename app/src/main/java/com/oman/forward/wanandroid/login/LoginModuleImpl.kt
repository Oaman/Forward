package com.oman.forward.wanandroid.login

import android.content.Context
import com.oman.forward.wanandroid.api.WanAndroidAPI
import com.oman.forward.wanandroid.net.APIResponse
import com.oman.forward.wanandroid.entity.LoginRegisterResponse
import com.oman.forward.wanandroid.login.inner.LoginListener
import com.oman.forward.wanandroid.login.inner.LoginModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class LoginModuleImpl : LoginModule {
    override fun loginAction(context: Context,
                                username: String,
                                password: String,
                                loginListener: LoginListener) {
        val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build()
        retrofit.create(WanAndroidAPI::class.java)
                .loginAction(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : APIResponse<LoginRegisterResponse>(context) {
                    override fun success(t: LoginRegisterResponse) {
                        loginListener.loginSuccess(t)
                    }

                    override fun failure(errorMsg: String?) {
                        loginListener.loginFailure(errorMsg)
                    }
                })
    }

    companion object {
        private const val baseUrl = "https://www.wanandroid.com"
    }

}