package com.study.utils.kotlin

import org.junit.jupiter.api.Test


class MainKotlin(var height: Double, length: Double) {
    var result = height + length
    var time = height * length


//    constructor() : this(0.0, 0.0)

    @Test
    fun test() {
        val mainKotlin = MainKotlin(3.1, 2.4)
        println("mainKotlin.result = ${mainKotlin.result}")
        println("mainKotlin.time = ${mainKotlin.time}")
        println("mainKotlin.height = ${mainKotlin.height}")
    }

/*    @Test
    fun test1() {
        var a = 1
        val s1 = "a is $a"
        a = 2
        // a was 1,but now is 2
        val s2 = "${s1.replace("is", "was")},but now is $a"
        println(s2)
    }*/

/*    @Test
    fun test2() {
        val items = listOf("apple", "banana", "kiwifruit")
        for (index in items.indices) {
            println("item at $index is ${items[index]}")
        }

        for (x in 1..3) {
            println(x)
        }
    }*/

//    private fun sum(a: Int, b: Int) = a + b

/*    @Test
    fun test3() {
        val a = 1
        val b = 2
        println("kotlin")
        println("$a + $b = ${a + b}")
        println("sum = ${sum(23, 32)}")
        println("sum = ${sum(32, 132)}")
    }*/


}