package com.oman.forward.study

import kotlin.concurrent.thread

/**

 * @author:ZhouJiang
 * @date:2020/3/23 17:25
 * @email:zhoujiang2012@163.com

 */
fun main() {
    val obj = Object()
    thread(name = "thread1") {
        println("thread1 waiting to get lock")
        synchronized(obj) {
            println("thread1 get lock")
            println("thread1 begin wait")
            Thread.sleep(1000)
            obj.wait()
            println("thread1 wait finish")
        }
    }

    thread(name = "thread2") {
        println("thread2 waiting to get lock")
        synchronized(obj) {
            println("thread2 get lock")
            println("thread2 begin notify")
            obj.notify()
            println("thread2 notify finish")
        }
    }
}