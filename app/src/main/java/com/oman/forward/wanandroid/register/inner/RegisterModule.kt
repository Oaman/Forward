package com.oman.forward.wanandroid.register.inner

import android.content.Context


interface RegisterModule {
    fun registerAction(context: Context, username: String, password: String,
                       rePassword: String, registerListener: RegisterListener)
}