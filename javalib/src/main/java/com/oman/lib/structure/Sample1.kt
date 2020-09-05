package com.oman.lib.structure

open class Person(val name: String, val age: Int)
class Student(name: String, age: Int) : Person(name, age)
class Teacher(name: String, age: Int) : Person(name, age)

class Sample<T> {
    var t: T? = null

    fun set(t: T) {
        this.t = t
    }

    fun get(): T? {
        return t
    }
}

fun handle(sample: Sample<Person>) {
    sample.set(Teacher("teacher1", 1))
}

fun main() {
    val student = Student("tom", 11)
    val sample = Sample<Student>()
    sample.set(student)
    //假如这里允许将Sample<Student>赋值给Sample<Person>的话，
    // 在handle内部就会出现再次赋值的情况，那么再次获取的时候就会出现了类型转换异常
//    handle(sample)
//    val stu: Student? = sample.get()
    /**
     * 就好比List<String>中添加了一些String后，将List<String>赋值给List<Object>,
     * 那我List<Object>中可以添加Integer吧，那么将来从List<Object>中获取的值是String还是Integer呢？
     * 就会出现类型转换异常，所以Java干脆就不允许这么做
     */


    println("------------------------------")
    /**
     * 想要放入的话就要使用out关键字
     */
    val sample2 = Sample2<Student>(student)
    handle2(sample2)
    val result  = sample2.get()
    println(result)
}

fun handle2(sample2: Sample2<Person>) {
    sample2.get()
    sample2.set(Teacher("tea",18))
}

/**
 * 使用了out之后，如果想将T放入in位置会报错,不允许放在in位置; 虽然可以使用@UnsafeVariance将其放入in位置，但是运行时候会报错运行时异常
 */
class Sample2<out T>(private var t: T?) {
    fun get(): T? {
        return t
    }

    //Type parameter T is declared as 'out' but occurs in 'in' position in type T?
    fun set(t: @UnsafeVariance T?) {
        this.t = t
    }
}


