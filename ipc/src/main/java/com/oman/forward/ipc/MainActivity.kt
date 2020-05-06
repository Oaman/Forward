package com.oman.forward.ipc

import android.app.Activity
import android.content.*
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.view.View
import android.widget.Toast
import com.oman.common.Constants.Companion.IPC_RECEIVER_ACTION_ROMAN
import com.oman.common.Constants.Companion.PACKAGE_NAME_FORWARD
import com.oman.common.NumberToRomanProviderInstance
import com.oman.forward.INumberToRoman
import kotlin.concurrent.thread

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun ipcBundle(view: View) {
        registerReceiverGetToken(object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val roman = intent.getStringExtra("roman")
                if (roman!!.isNotEmpty()) {
                    Toast.makeText(context, roman, Toast.LENGTH_LONG).show()
                }
            }
        })
        sendGetRomanReceiver(this)
    }

    private fun registerReceiverGetToken(receiver: BroadcastReceiver) {
        val intentFilter = IntentFilter()
        intentFilter.addAction(IPC_RECEIVER_ACTION_ROMAN)
        registerReceiver(receiver, intentFilter)
    }

    fun ipcAIDL(view: View) {
        with(Intent()) {
            setPackage(PACKAGE_NAME_FORWARD)
            setClassName(PACKAGE_NAME_FORWARD, "com.oman.forward.ipc.NumberToRomanService")
            bindService(this, object : ServiceConnection {
                override fun onServiceDisconnected(name: ComponentName?) {
                    Log.i("aaa", "death2: ")
                }

                override fun onServiceConnected(name: ComponentName, service: IBinder) {
                    thread {
                        val binder = MyNumberToRoman.Stub.asInterface(service)
                        Log.i("aaa", "client: ${binder.numberToRoman(1234)} ${Thread.currentThread().name}")
                        service.linkToDeath({
                            Log.i("aaa", "death: ")
                        }, 0)
                    }
                }

            }, Context.BIND_AUTO_CREATE)
        }
    }

    fun ipcProvider(view: View) {
        NumberToRomanProviderInstance.getInstance(this)
                .getRoman(this, 1000)
                .let {
                    Log.i("aaa", "provider: $it")
                }
    }
}
