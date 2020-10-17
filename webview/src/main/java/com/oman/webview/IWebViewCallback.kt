package com.oman.webview

interface IWebViewCallback {
    fun onPageStart(url: String)
    fun onPageFinish(url: String)
    fun onError()
    fun updateTitle(title: String)
}