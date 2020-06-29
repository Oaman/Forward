package com.oman.forward.wanandroid.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.oman.forward.DashboardActivity
import com.oman.forward.R
import com.oman.forward.wanandroid.base.BaseActivity
import com.oman.forward.wanandroid.login.inner.LoginPresenter
import com.oman.forward.wanandroid.login.inner.LoginView
import com.oman.forward.wanandroid.register.isValid
import com.oman.forward.wanandroid.register.toast
import kotlinx.android.synthetic.main.activity_register.*

class LoginActivity : BaseActivity<LoginPresenter>(), LoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun createPresenter(): LoginPresenter {
        return LoginPresenterImpl(this)
    }

    fun loginAction(view: View) {
        val userName = userAccount.text.trim().toString()
        val password = userPassword.text.trim().toString()
        if (isValid(userName, password)) {
            presenter.loginAction(this, userName, password)
        }
    }

    override fun <T> loginSuccess(t: T) {
        toast("登陆成功😀")
        startActivity(Intent(this, DashboardActivity::class.java))
        finish()
    }

    override fun loginFailure(errorMsg: String?) {
        toast(errorMsg)
    }

    override fun recycle() {
        //TODO do some recycle work
    }

}