package com.oman.forward.command

import android.content.ComponentName
import android.content.Intent
import android.text.TextUtils
import com.google.auto.service.AutoService
import com.oman.base.BaseApplication
import com.oman.webview.command.Command

@AutoService(Command::class)
class OpenPageCommand : Command {
    override fun name(): String = "openActivity"

    override fun executeCommand(params: MutableMap<Any?, Any?>) {
        val targetClass: String = params["className"].toString()
        if (!TextUtils.isEmpty(targetClass)) {
            val intent = Intent()
            intent.component = ComponentName(BaseApplication.sApplication, targetClass)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            BaseApplication.sApplication.startActivity(intent)
        }
    }
}