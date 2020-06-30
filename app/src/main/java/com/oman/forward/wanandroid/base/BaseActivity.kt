package com.oman.forward.wanandroid.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity<P> : AppCompatActivity() where P : IBasePresenter {

    lateinit var presenter: P

    override
    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = createPresenter()
    }

    override fun onDestroy() {
        super.onDestroy()
        recycle()
    }

    abstract fun createPresenter(): P

    abstract fun recycle()

    companion object {
        const val KEY_USER_ACCOUNT = "key_user_account"
        const val KEY_USER_PASSWORD = "key_user_password"
    }
}