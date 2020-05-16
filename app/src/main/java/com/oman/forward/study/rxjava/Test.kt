package com.oman.forward.study.rxjava

/**

 * @author:ZhouJiang
 * @date:2020/5/11 12:02
 * @email:zhoujiang2012@163.com

 */


val lambda = { s: String ->
    s.length
}

val plus = { a: Int, b: Int ->
    a + b
}

fun minus(a: Int, b: Int): Int {
    return a - b
}

fun num1AndNum2(a: Int, b: Int, operator: (Int, Int) -> Int): Int {
    return operator(a, b)
}

fun <T, R : Comparable<R>> List<T>.findMax(block: (T) -> R): T? {
    if (isEmpty()) return null
    var maxElement = get(0)
    var maxValue = block(maxElement)
    for (element in this) {
        val value = block(element)
        if (value > maxValue) {
            maxElement = element
            maxValue = value
        }
    }
    return maxElement
}

fun main() {
    num1AndNum2(1, 2, plus)
    num1AndNum2(1, 2, ::minus)
    num1AndNum2(1, 2) { a, b ->
        a * b
    }
    //Kotlin中想要使用lambda表达式 调用和接口必须是java类型，否则就得使用object:xxx{}之类的
    val button = Button()
    button.setOnClickListener {
        println(it)
    }
    //java中调用
//    button.setOnClickListener(string -> {
//        System.out.println(string);
//    });
    println(listOf("12", "234").maxBy {
        it.length
    })
    println(listOf("1223", "234").findMax {
        it
    })


    println("hello".capitalize().reversed())
    println("hello".reversed())
    println("code".hello())
    println(listOf("1", "23").maxBy {
        it.length
    })
}

fun String.hello(): String {
    val charArr = this.toCharArray()
    charArr[length - 1] = charArr[length - 1].toUpperCase()
    return String(charArr)
}