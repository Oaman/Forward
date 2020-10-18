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

/**
 * 1 AutoService注解可以在webView组件获取上层app应用的具体注解实现(虽然不能代码显示调用到)，这样就很方便调用上层的实现
 * 2 子组件可以通过反射或者其它方法打开上层应用注册过的activity
 * 3 组件化的话可以不用声明两个aidl来跨进程，一个就够了，因为声明aidl就是为了方便使用，但是因为组件化的话，主app已经持有了子app的aidl，
 *  所以可以共用一个接口；主要是看有没有在主进程service注册（extend Stub），然后在客户端使用，就是在客户端调用as stub使用
 */
class BaseWebView(context: Context, attrs: AttributeSet) : WebView(context, attrs) {
    init {
        init()
    }

    private fun init() {
        /**
         * 1 初始化aidl，启动service, 获取AUTO_SERVICE注解的实现类
         */
        WebViewCommandDispatcher.getInstance().initAidl()
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
                /**
                 * 2 点击时候就调用这里处理命令
                 */
                WebViewCommandDispatcher.getInstance().executeCommand(jsParamObject.name, Gson().toJson(jsParamObject.param))

//                if ("showToast".equals(jsParamObject.name, ignoreCase = true)) {
//                    Toast.makeText(context, Gson().fromJson<Map<*, *>>(jsParamObject.param, MutableMap::class.java)["message"].toString(), Toast.LENGTH_LONG).show()
//                }
            }
        }
    }

    companion object {
        const val TAG = "webView"
    }
}