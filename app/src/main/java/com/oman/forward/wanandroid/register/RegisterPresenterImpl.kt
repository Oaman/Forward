package com.oman.forward.wanandroid.register

import android.content.Context
import com.oman.forward.wanandroid.register.inner.RegisterListener
import com.oman.forward.wanandroid.register.inner.RegisterPresenter
import com.oman.forward.wanandroid.register.inner.RegisterView

class RegisterPresenterImpl(private var registerView: RegisterView?) : RegisterPresenter, RegisterListener {

    private val registerModule = RegisterModuleImpl()

    override fun registerAction(context: Context, username: String, password: String, rePassword: String) {
        registerModule.registerAction(username, password, rePassword, this)
    }

    override fun unAttach() {
        registerView = null
    }

    override fun <T> registerSuccess(t: T) {
        registerView?.registerSuccess(t)
    }

    override fun registerFailure(errorMsg: String?) {
        registerView?.registerFailure(errorMsg)
    }

}