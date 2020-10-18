package com.oman.webview.mainprocess

import android.os.RemoteException
import com.google.gson.Gson
import com.oman.webview.IWebViewToMainCommand
import com.oman.webview.command.Command
import java.util.*

class MainProcessCommandManager private constructor() : IWebViewToMainCommand.Stub() {

    private val mCommands = HashMap<String, Command>()

    init {
        val commands = ServiceLoader.load(Command::class.java)
        for (command in commands)
            if (!mCommands.containsKey(command.name())) mCommands[command.name()] = command

    }

    private fun executeCommand(commandName: String, params: Map<*, *>) {
        mCommands[commandName]?.executeCommand(params)
    }

    @Throws(RemoteException::class)
    override fun handCommand(commandName: String, json: String) {
        executeCommand(commandName, Gson().fromJson<Map<*, *>>(json, MutableMap::class.java))
    }

    companion object {
        @Volatile
        private var instance: MainProcessCommandManager? = null

        @JvmStatic
        fun getInstance(): MainProcessCommandManager =
                instance ?: synchronized(MainProcessCommandManager::class.java) {
                    instance ?: MainProcessCommandManager().apply {
                        instance = this
                    }
                }
    }
}