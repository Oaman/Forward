package com.oman.forward.ipc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.oman.forward.utils.sendGetRomanReceiver
import java.util.concurrent.Executors

/**

 * @author:ZhouJiang
 * @date:2020/3/14 14:21
 * @email:zhoujiang2012@163.com

 */
class RomanReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.i("aaa", "getReceiver: ${intent.getIntExtra("number", 0)}")
        val result = goAsync()
        Executors.newSingleThreadExecutor().execute {
            val roman = NumberToRoman.numberToRoman(intent.getIntExtra("number", 0))
            //sleep to monitor Time-consuming operation.
            Thread.sleep(2000)
            sendGetRomanReceiver(context, roman)
            result.finish()
        }
    }
}