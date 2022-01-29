package com.spring.jpa.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


fun main() {
    val a = 1
    val b = 2
    println("kotlin")
    println("$a + $b = ${a + b}")
    val kotlinTestController = KotlinTestController()
    println(kotlinTestController.test())
    println("sum = ${sum(23, 32)}")
}

fun sum(a: Int, b: Int) = a + b

@RestController
class KotlinTestController {


    @RequestMapping("/kotlin")
    fun test(): String {
        return "kotlin"
    }


}