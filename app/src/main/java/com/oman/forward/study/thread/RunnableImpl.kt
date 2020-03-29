package com.oman.forward.study

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import kotlin.concurrent.thread

/**

 * @author:ZhouJiang
 * @date:2020/3/22 22:44
 * @email:zhoujiang2012@163.com

 */
class RunnableImpl : Runnable {
    override fun run() {
        println("this is test for runnable")
    }
}

class ThreadExtend : Thread() {
    override fun run() {
        println("this is test for thread")
    }
}

class CallableImpl : Callable<String> {
    override fun call(): String {
        Thread.sleep(3000)
        return "callable impl"
    }
}

fun main() {
    Thread(RunnableImpl()).start()
    ThreadExtend().start()
    Executors.newSingleThreadExecutor().execute {
        println("thread pool")
    }
    println("before future get")
    Executors.newSingleThreadExecutor().submit(CallableImpl()).let {
        println(it.get())
    }
    println("after future get")
}
