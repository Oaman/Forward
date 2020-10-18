package com.oman.webview.webviewprocess.webviewchromeclient

import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.oman.webview.IWebViewCallback

class MyWebViewChromeClient(val callback: IWebViewCallback) : WebChromeClient() {
    override fun onReceivedTitle(view: WebView, title: String) {
        callback.updateTitle(title)
    }

    /**
     * this is very convenient to get log here
     */
    override fun onConsoleMessage(consoleMessage: ConsoleMessage): Boolean {
        Log.i("webView", "onConsoleMessage: " + consoleMessage.message())
        return super.onConsoleMessage(consoleMessage)
    }
}