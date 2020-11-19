package com.oman.kotlin

import kotlinx.coroutines.*


//val callback = {
//    println("C")
//}
//val talk = {
//    println("D")
//    callback()
//}

suspend fun main() {
    runBlocking {
        launch(Dispatchers.Default) {
            println("aaa ${Thread.currentThread().name}")
            delay(2000)
            println("bbb ${Thread.currentThread().name}")
        }
        launch(Dispatchers.IO) {
            println("ccc ${Thread.currentThread().name}")
            delay(2000)
            println("ddd ${Thread.currentThread().name}")
        }
    }
    println("finish ${Thread.currentThread().name}")
}

//inline fun get(block: (String) -> Unit) {
//    block.invoke("data")
//}

//val continuation = suspend {
//    println("in coroutine")
//    4
//}.startCoroutine(object : Continuation<Int> {
//    override val context: CoroutineContext
//        get() = EmptyCoroutineContext
//
//    override fun resumeWith(result: Result<Int>) {
//        println("end ${result.getOrNull()}")
//    }
//})