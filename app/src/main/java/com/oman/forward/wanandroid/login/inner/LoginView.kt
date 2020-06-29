package com.oman.forward.wanandroid.login.inner

interface LoginView {
    fun <T> loginSuccess(t: T)
    fun loginFailure(errorMsg: String?)
}