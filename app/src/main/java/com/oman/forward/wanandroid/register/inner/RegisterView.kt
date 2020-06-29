package com.oman.forward.wanandroid.register.inner

interface RegisterView {
    fun <T> registerSuccess(t: T)
    fun registerFailure(errorMsg: String?)
}