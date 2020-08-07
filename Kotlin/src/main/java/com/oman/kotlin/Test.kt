package com.oman.kotlin

import kotlin.concurrent.thread


fun main() {
    Button1().setOnClickListener {
        println("kt onClick ${Thread.currentThread().name}")
    }
    println(AA("123"))
}


val AA: (String) -> Int = { s ->
    s.toInt()
}

fun b(s: String, block: (String) -> Int) {
    println(block(s))
}

fun a(s: String): Int {
    return s.toInt()
}


class Button1 {
    fun setOnClickListener(block: () -> Unit) {
        thread {
            block()
        }
        println("kt main ${Thread.currentThread().name}")
    }

}
