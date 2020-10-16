package com.oman.forward.wanandroid.login.inner


interface LoginModule {
    fun loginAction(username: String, password: String,
                       loginListener: LoginListener)
}