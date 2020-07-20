package com.oman.kotlin

import java.lang.Exception

fun main() {
    val a = 1
    println(a is Int)
    println(a !is Int)
    println(a as Int)
    val b = a as Int
    println(b)
    println("-------")
    var s: String? = null
    println(s ?: "aa")
//    s = s ?: "bb"
    println(s)
    age("1") {
        it.toInt()
    }
}
typealias A = (String) -> Int

fun age(str: String, a: A) = a(str)

fun test() {
    throw Exception("")
}