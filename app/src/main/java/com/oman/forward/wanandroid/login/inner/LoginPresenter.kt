package com.oman.forward.wanandroid.login.inner

import android.content.Context
import com.oman.forward.wanandroid.base.IBasePresenter

interface LoginPresenter : IBasePresenter {
    fun loginAction(context: Context, username: String, password: String)
}

interface LoginListener {
    fun <T> loginSuccess(t: T)
    fun loginFailure(errorMsg: String?)
}