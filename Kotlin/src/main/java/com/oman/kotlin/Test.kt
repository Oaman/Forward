package com.oman.kotlin

import kotlin.concurrent.thread


val callback = {
    println("C")
}
val talk = {
    println("D")
    callback()
}

fun main() {
    println("A")
    talk.invoke()
    println("B")
}
