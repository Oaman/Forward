package com.oman.webview

import android.graphics.Bitmap
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class MyWebViewClient(val callback: IWebViewCallback) : WebViewClient() {

    override fun onPageStarted(view: WebView?, url: String, favicon: Bitmap?) {
        callback.onPageStart(url)
    }

    override fun onPageFinished(view: WebView?, url: String) {
        callback.onPageFinish(url)
    }

    override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
        super.onReceivedError(view, request, error)
        callback.onError()
    }
}