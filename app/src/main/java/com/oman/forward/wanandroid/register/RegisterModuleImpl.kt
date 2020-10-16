package com.oman.forward.wanandroid.register

import com.oman.forward.wanandroid.api.WanAndroidAPI
import com.oman.forward.wanandroid.entity.LoginRegisterResponse
import com.oman.forward.wanandroid.net.APIResponse
import com.oman.forward.wanandroid.net.RetrofitClient
import com.oman.forward.wanandroid.register.inner.RegisterListener
import com.oman.forward.wanandroid.register.inner.RegisterModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RegisterModuleImpl : RegisterModule {
    override fun registerAction(username: String,
                                password: String,
                                rePassword: String,
                                registerListener: RegisterListener) {

        RetrofitClient.getInstance()
                .create(WanAndroidAPI::class.java)
                .registerAction(username, password, rePassword)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : APIResponse<LoginRegisterResponse>() {
                    override fun success(t: LoginRegisterResponse) {
                        registerListener.registerSuccess(t)
                    }

                    override fun failure(errorMsg: String?) {
                        registerListener.registerFailure(errorMsg)
                    }
                })
    }

    companion object {
        const val BASE_URL = "https://www.wanandroid.com"
    }

}