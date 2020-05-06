package com.oman.forward.ipc

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.oman.forward.INumberToRoman

/**

 * @author:ZhouJiang
 * @date:2020/3/14 18:48
 * @email:zhoujiang2012@163.com

 */
class NumberToRomanService : Service() {

    private val binder = object : MyNumberToRoman.Stub() {
        override fun numberToRoman(number: Int): String {
            val name = packageManager.getPackagesForUid(Binder.getCallingUid())
            Log.i("aaa", "caller: ${name?.get(0)} packageName:${Binder.getCallingUid()} threadName:${Thread.currentThread().name}")
            return NumberToRoman.numberToRoman(number)
        }
    }

    override fun onBind(intent: Intent?): IBinder? {
        return binder
    }
}