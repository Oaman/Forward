package com.oman.common.autoservice

import android.content.Context

interface IWebViewService {
    fun startWebView(context: Context, url: String, title: String, showToolbar: Boolean)
}