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

class WebViewActivity : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(intent.getStringExtra(KEY_WEB_URL))
        toolbar.visibility = if (intent.getBooleanExtra(KEY_WEB_IS_SHOW_ACTION_BAR, false)) View.VISIBLE else View.GONE
        toolbar.title = intent.getStringExtra(KEY_WEB_TITLE)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}