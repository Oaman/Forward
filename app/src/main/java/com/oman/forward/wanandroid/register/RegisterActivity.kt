package com.oman.forward.wanandroid.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.oman.forward.R
import com.oman.forward.wanandroid.base.BaseActivity
import com.oman.forward.wanandroid.login.LoginActivity
import com.oman.forward.wanandroid.register.inner.RegisterPresenter
import com.oman.forward.wanandroid.register.inner.RegisterView
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseActivity<RegisterPresenter>(), RegisterView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }

    override fun createPresenter(): RegisterPresenter {
        return RegisterPresenterImpl(this)
    }

    fun registerAction(view: View) {
        val userName = userAccount.text.trim().toString()
        val password = userPassword.text.trim().toString()
        val rePassword = userRePassword.text.trim().toString()
        if (isValid(userName, password, rePassword)) {
            presenter.registerAction(this, userName, password, rePassword)
        }
    }

    override fun <T> registerSuccess(t: T) {
        toast("注册成功😀")
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

    override fun registerFailure(errorMsg: String?) {
        toast(errorMsg)
    }

    override fun recycle() {
        //TODO do some recycle work
    }
}

public fun isValid(vararg args: String): Boolean {
    for (s in args) {
        if (TextUtils.isEmpty(s)) return false
    }
    return true
}

public fun Context.toast(content: String?) {
    Toast.makeText(this, content, Toast.LENGTH_SHORT).show()
}