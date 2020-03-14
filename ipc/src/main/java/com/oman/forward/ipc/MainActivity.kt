package com.oman.forward.ipc

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.oman.common.Constants.Companion.IPC_RECEIVER_ACTION_ROMAN

class MainActivity : AppCompatActivity() {

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
    }
}
