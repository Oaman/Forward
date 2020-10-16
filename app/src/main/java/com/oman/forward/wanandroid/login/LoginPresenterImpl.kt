package com.oman.forward.wanandroid.login

import android.content.Context
import com.oman.forward.wanandroid.login.inner.LoginListener
import com.oman.forward.wanandroid.login.inner.LoginPresenter
import com.oman.forward.wanandroid.login.inner.LoginView

class LoginPresenterImpl(private var loginView: LoginView?) : LoginPresenter, LoginListener {
    private val registerModule = LoginModuleImpl()
    override fun loginAction(context: Context, username: String, password: String) {
        registerModule.loginAction(username, password, this)
    }

    override fun unAttach() {
        loginView = null
    }

    override fun <T> loginSuccess(t: T) {
        loginView?.loginSuccess(t)
    }

    override fun loginFailure(errorMsg: String?) {
        loginView?.loginFailure(errorMsg)
    }

}