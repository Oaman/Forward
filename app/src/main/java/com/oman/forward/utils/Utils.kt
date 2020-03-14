package com.oman.forward.utils

import android.content.Context
import android.content.Intent
import com.oman.common.Constants
import com.oman.common.Constants.Companion.PACKAGE_NAME_IPC

/**

 * @author:ZhouJiang
 * @date:2020/3/14 14:45
 * @email:zhoujiang2012@163.com

 */
fun sendGetRomanReceiver(context: Context, roman: String) {
    with(Intent(Constants.IPC_RECEIVER_ACTION_ROMAN)) {
        setPackage(PACKAGE_NAME_IPC)
        putExtra("roman", roman)
        context.sendBroadcast(this)
    }
}