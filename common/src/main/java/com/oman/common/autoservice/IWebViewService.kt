package com.oman.common.autoservice

import android.content.Context
import androidx.fragment.app.Fragment

interface IWebViewService {
    fun startWebView(context: Context, url: String, title: String, showToolbar: Boolean)

    fun getWebViewFragment(url: String, canRefresh: Boolean): Fragment

    fun startDemoHtml(context: Context)
}