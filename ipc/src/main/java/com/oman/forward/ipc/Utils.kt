package com.oman.forward.ipc

import android.content.Context
import android.content.Intent
import com.oman.common.Constants.Companion.PACKAGE_NAME_FORWARD
import com.oman.common.Constants.Companion.RECEIVER_CLASSNAME_ROMAN

/**

 * @author:ZhouJiang
 * @date:2020/3/14 14:20
 * @email:zhoujiang2012@163.com

 */
fun sendGetRomanReceiver(context: Context, number: Int = 1000) {
    with(Intent()) {
        //setClassName("com.oman.forward", "com.oman.forward.ipc.RomanReceiver")
        setClassName(PACKAGE_NAME_FORWARD, RECEIVER_CLASSNAME_ROMAN)
        putExtra("number", number)
        context.sendBroadcast(this)
    }
}