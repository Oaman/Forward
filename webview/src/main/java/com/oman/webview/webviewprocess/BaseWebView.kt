package com.oman.webview.webviewprocess

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.util.Log
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast
import com.google.gson.Gson
import com.oman.webview.IWebViewCallback
import com.oman.webview.bean.JsParam
import com.oman.webview.webviewprocess.websettings.WebViewDefaultSettings
import com.oman.webview.webviewprocess.webviewchromeclient.MyWebViewChromeClient
import com.oman.webview.webviewprocess.webviewclient.MyWebViewClient

class BaseWebView(context: Context, attrs: AttributeSet) : WebView(context, attrs) {
    init {
        init()
    }

    private fun init() {
        WebViewDefaultSettings.getInstance().setSettings(this)
        addJavascriptInterface(this, "toastwebview")
    }

    fun registerWebViewCallBack(webViewCallBack: IWebViewCallback?) {
        webViewClient = MyWebViewClient(webViewCallBack!!)
        webChromeClient = MyWebViewChromeClient(webViewCallBack)
    }

    /**
     * 1 demo.html中声明onclick调用js代码
     * 2 js中代码根据设置的interfaceName调用native java代码
     */
    @JavascriptInterface
    fun nativeInvoke(jsParam: String) {
        Log.i(TAG, jsParam)
        if (!TextUtils.isEmpty(jsParam)) {
            val jsParamObject = Gson().fromJson(jsParam, JsParam::class.java)
            if (jsParamObject != null) {
                if ("showToast".equals(jsParamObject.name, ignoreCase = true)) {
                    Toast.makeText(context, Gson().fromJson<Map<*, *>>(jsParamObject.param, MutableMap::class.java)["message"].toString(), Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    companion object {
        const val TAG = "webView"
    }
}