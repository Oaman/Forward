package com.oman.webview

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.kingja.loadsir.core.LoadService
import com.kingja.loadsir.core.LoadSir
import com.oman.base.loadsir.ErrorCallback
import com.oman.base.loadsir.LoadingCallback
import com.oman.common.Constants.Companion.KEY_CAN_REFRESH
import com.oman.common.Constants.Companion.KEY_WEB_URL
import com.oman.webview.webviewprocess.BaseWebView
import com.oman.webview.webviewprocess.webviewchromeclient.MyWebViewChromeClient
import com.oman.webview.webviewprocess.webviewclient.MyWebViewClient
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.api.RefreshLayout
import com.scwang.smartrefresh.layout.listener.OnRefreshListener

class WebViewFragment : Fragment(), OnRefreshListener, IWebViewCallback {

    private var canRefresh: Boolean = false
    private lateinit var loadService: LoadService<*>
    private var hasError: Boolean = false
    private var webView: BaseWebView? = null
    private var smartRefreshLayout: SmartRefreshLayout? = null

    companion object {
        fun getInstance(url: String, canRefresh: Boolean): Fragment {
            val fragment = WebViewFragment()
            fragment.arguments = bundleOf(KEY_WEB_URL to url, KEY_CAN_REFRESH to canRefresh)
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        canRefresh = arguments?.getBoolean(KEY_CAN_REFRESH, false)!!
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_webview, container, false)
        webView = rootView.findViewById(R.id.webView)

        webView?.registerWebViewCallBack(this)
        smartRefreshLayout = rootView.findViewById(R.id.smartRefreshLayout)

        webView?.settings?.javaScriptEnabled = true
        webView?.loadUrl(arguments?.getString(KEY_WEB_URL)!!)
        loadService = LoadSir.getDefault().register(smartRefreshLayout) {
            loadService.showCallback(LoadingCallback::class.java)
            webView?.reload()
        }
        smartRefreshLayout?.setOnRefreshListener(this)
        smartRefreshLayout?.isEnableRefresh = canRefresh
        smartRefreshLayout?.isEnableLoadMore = false

        return loadService.loadLayout
    }

    override fun onRefresh(refreshLayout: RefreshLayout) {
        webView?.reload()
    }

    override fun onPageStart(url: String) {
        loadService.showCallback(LoadingCallback::class.java)
    }

    override fun onPageFinish(url: String) {
        smartRefreshLayout?.isEnableRefresh = if (hasError) true else canRefresh
        smartRefreshLayout?.finishRefresh()
        loadService.let {
            if (hasError) loadService.showCallback(ErrorCallback::class.java) else loadService.showSuccess()
        }
        hasError = false
    }

    /**
     * this method will call onPageFinished
     */
    override fun onError() {
        hasError = true
        smartRefreshLayout?.finishRefresh()
    }

    override fun updateTitle(title: String) {
        callback?.updateTitle(title)
    }

    private var callback: UpdateTitleCallback? = null
    fun setUpdateTitleCallback(updateTitleCallback: UpdateTitleCallback) {
        callback = updateTitleCallback
    }
}