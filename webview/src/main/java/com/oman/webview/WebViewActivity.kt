package com.oman.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.oman.common.Constants.Companion.KEY_WEB_IS_SHOW_ACTION_BAR
import com.oman.common.Constants.Companion.KEY_WEB_TITLE
import com.oman.common.Constants.Companion.KEY_WEB_URL
import kotlinx.android.synthetic.main.activity_webview.*


/**
 *  https://mp.weixin.qq.com/s/5Hs9Bg93IbY2uRUMeIqAJQ
 */
class WebViewActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        setSupportActionBar(toolbar)
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
        }
        toolbar.visibility = if (intent.getBooleanExtra(KEY_WEB_IS_SHOW_ACTION_BAR, false)) View.VISIBLE else View.GONE
        toolbar.title = intent.getStringExtra(KEY_WEB_TITLE)

        val transaction = supportFragmentManager.beginTransaction()
        val fragment = WebViewFragment.getInstance(intent.getStringExtra(KEY_WEB_URL)!!, true)
        transaction.replace(R.id.fragmentContainer, fragment).commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

    fun updateTitle(title:String) {
        toolbar.title = title
    }
}