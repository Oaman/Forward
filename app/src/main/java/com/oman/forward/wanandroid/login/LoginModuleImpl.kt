package com.oman.forward.wanandroid.login

import com.oman.forward.wanandroid.api.WanAndroidAPI
import com.oman.forward.wanandroid.net.APIResponse
import com.oman.forward.wanandroid.entity.LoginRegisterResponse
import com.oman.forward.wanandroid.login.inner.LoginListener
import com.oman.forward.wanandroid.login.inner.LoginModule
import com.oman.forward.wanandroid.net.RetrofitClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LoginModuleImpl : LoginModule {
    override fun loginAction(username: String,
                             password: String,
                             loginListener: LoginListener) {

        RetrofitClient.getInstance()
                .create(WanAndroidAPI::class.java)
                .loginAction(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : APIResponse<LoginRegisterResponse>() {
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