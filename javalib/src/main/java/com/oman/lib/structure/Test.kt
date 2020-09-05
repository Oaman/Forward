package com.oman.lib.structure

class SimpleData<out T>(private val data: T?) {

    fun get(): T? {
        return data
    }

}

fun handleMyData(data: SimpleData<Person>) {
    val personData = data.get()
}

fun main() {
    val student = Student("Tom", 19)
    val data = SimpleData<Student>(student)
    handleMyData(data)
    val studentData = data.get()

//    val trans = object : Transformer<Person> {
//        override fun transform(t: Person): String {
//            return "${t.name} ${t.age}"
//        }
//    }
//    handleTransformer(trans)

    val trans = object : Transformer<Person> {
        override fun transform(name: String, age: Int): Person {
            return Teacher(name, age)
        }
    }
    handleTransformer(trans)

    //todo 协变的使用在kotlin的list中，逆变在comparable中使用
    var a = listOf<Number>(1, 2, 3)
    var b = listOf<Int>(1, 2, 3)


    println(a[0].javaClass)
    a = b
    println(a[0].javaClass)
}

//
//interface Transformer<in T> {
//    fun transform(t: T): String
//}
//
//fun handleTransformer(trans: Transformer<Student>) {
//    val student = Student("Tom", 19)
//    val result = trans.transform(student)
//}


interface Transformer<in T> {
    fun transform(name: String, age: Int): @UnsafeVariance T
}

fun handleTransformer(trans: Transformer<Student>) {
    val result = trans.transform("Tom", 19)
}
