package com.oman.forward.ipc

import android.app.Service
import android.content.Intent
import android.os.IBinder
import com.oman.forward.INumberToRoman

/**

 * @author:ZhouJiang
 * @date:2020/3/14 18:48
 * @email:zhoujiang2012@163.com

 */
class NumberToRomanService : Service() {

    private val binder = object : INumberToRoman.Stub() {
        override fun numberToRoman(number: Int): String {
            return NumberToRoman.numberToRoman(number)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }
}