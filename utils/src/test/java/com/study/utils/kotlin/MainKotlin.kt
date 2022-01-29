package com.study.utils.kotlin


fun main() {
    val mainKotlin = MainKotlin(3.1, 2.4)
    println("mainKotlin.result = ${mainKotlin.result}")
    println("mainKotlin.time = ${mainKotlin.time}")
    println("mainKotlin.height = ${mainKotlin.height}")

    var a = 1
    val s1 = "a is $a"
    a = 2
    // a was 1,but now is 2
    val s2 = "${s1.replace("is", "was")},but now is $a"
    println(s2)

    val items = listOf<String>("apple", "banana", "kiwifruit")
    for (index in items.indices) {
        println("item at $index is ${items[index]}")
    }

    for (x in 1..3){
        println(x)
    }


}

class MainKotlin(var height: Double, length: Double) {
    var result = height + length
    var time = height * length
}