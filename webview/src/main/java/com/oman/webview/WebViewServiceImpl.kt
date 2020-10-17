package com.oman.webview

import android.content.Context
import android.content.Intent
import com.google.auto.service.AutoService
import com.oman.common.Constants.Companion.KEY_WEB_IS_SHOW_ACTION_BAR
import com.oman.common.Constants.Companion.KEY_WEB_TITLE
import com.oman.common.Constants.Companion.KEY_WEB_URL
import com.oman.common.autoservice.IWebViewService

@AutoService(IWebViewService::class)
class WebViewServiceImpl : IWebViewService {
    override fun startWebView(context: Context, url: String, title: String, showToolbar: Boolean) {
        startActivity<WebViewActivity>(context) {
            putExtra(KEY_WEB_TITLE, title)
            putExtra(KEY_WEB_URL, url)
            putExtra(KEY_WEB_IS_SHOW_ACTION_BAR, showToolbar)
        }
    }
}

inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}
