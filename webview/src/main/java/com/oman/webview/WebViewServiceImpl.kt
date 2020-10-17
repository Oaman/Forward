package com.oman.webview

import android.content.Context
import androidx.fragment.app.Fragment
import com.google.auto.service.AutoService
import com.oman.common.Constants.Companion.ANDROID_ASSET_URI
import com.oman.common.Constants.Companion.KEY_WEB_IS_SHOW_ACTION_BAR
import com.oman.common.Constants.Companion.KEY_WEB_TITLE
import com.oman.common.Constants.Companion.KEY_WEB_URL
import com.oman.common.autoservice.IWebViewService
import com.oman.common.startActivity

@AutoService(IWebViewService::class)
class WebViewServiceImpl : IWebViewService {
    override fun startWebView(context: Context, url: String, title: String, showToolbar: Boolean) {
        startActivity<WebViewActivity>(context) {
            putExtra(KEY_WEB_TITLE, title)
            putExtra(KEY_WEB_URL, url)
            putExtra(KEY_WEB_IS_SHOW_ACTION_BAR, showToolbar)
        }
    }

    override fun getWebViewFragment(url: String, canRefresh: Boolean): Fragment {
        return WebViewFragment.getInstance(url, canRefresh)
    }

    override fun startDemoHtml(context: Context) {
        startActivity<WebViewActivity>(context) {
            putExtra(KEY_WEB_TITLE, "Demo html测试")
            putExtra(KEY_WEB_URL, ANDROID_ASSET_URI + "demo.html")
        }
    }
}
