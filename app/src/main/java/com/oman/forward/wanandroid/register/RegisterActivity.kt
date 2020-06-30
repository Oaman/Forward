package com.oman.forward.wanandroid.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.core.content.edit
import com.oman.forward.DashboardActivity
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
        if (getSharedPreferences(PREF_NAME, 0).getBoolean(KEY_REGISTERED, false)) {
            DashboardActivity.startSelf(this)
        }
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
        getSharedPreferences(PREF_NAME, 0).edit {
            putBoolean(KEY_REGISTERED, true)
        }
        //TODO just monitor
        with(Intent(this, LoginActivity::class.java)) {
            putExtra(KEY_USER_ACCOUNT, userAccount.text.trim().toString())
            startActivity(this)
        }
        finish()
    }

    override fun registerFailure(errorMsg: String?) {
        toast(errorMsg)
    }

    override fun recycle() {
        //TODO do some recycle work
    }

    companion object {
        const val PREF_NAME = "register"
        const val KEY_REGISTERED = "key_registered"
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
