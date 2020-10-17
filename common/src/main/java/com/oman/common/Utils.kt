package com.oman.common

import android.content.Context
import android.content.Intent

inline fun <reified T> startActivity(context: Context) {
    context.startActivity(Intent(context, T::class.java))
}

inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}