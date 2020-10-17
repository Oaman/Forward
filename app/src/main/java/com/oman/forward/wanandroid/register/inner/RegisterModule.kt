package com.oman.forward.wanandroid.register.inner

interface RegisterModule {
    fun registerAction(username: String, password: String,
                       rePassword: String, registerListener: RegisterListener)
}