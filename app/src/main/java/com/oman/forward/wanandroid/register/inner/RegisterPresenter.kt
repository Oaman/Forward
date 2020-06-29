package com.oman.forward.wanandroid.register.inner

import android.content.Context
import com.oman.forward.wanandroid.base.IBasePresenter

interface RegisterPresenter : IBasePresenter {
    fun registerAction(context: Context, username: String, password: String, rePassword: String)
}

interface RegisterListener {
    fun <T> registerSuccess(t: T)
    fun registerFailure(errorMsg: String?)
}