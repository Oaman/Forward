package com.oman.webview

import android.webkit.WebChromeClient
import android.webkit.WebView

class MyWebViewChromeClient(val callback: IWebViewCallback) : WebChromeClient() {
    override fun onReceivedTitle(view: WebView, title: String) {
        callback.updateTitle(title)
    }
}