package com.oman.forward.wanandroid.login.inner

import android.content.Context


interface LoginModule {
    fun loginAction(context: Context, username: String, password: String,
                       loginListener: LoginListener)
}