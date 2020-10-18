package com.oman.forward.command

import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.auto.service.AutoService
import com.oman.base.BaseApplication
import com.oman.webview.command.Command

@AutoService(Command::class)
class ShowToastCommand : Command {
    override fun name(): String {
        return "showToast"
    }

    override fun executeCommand(params: Map<*, *>) {
        val handler = Handler(Looper.getMainLooper())
        handler.post { Toast.makeText(BaseApplication.sApplication, params["message"].toString(), Toast.LENGTH_SHORT).show() }
    }
}