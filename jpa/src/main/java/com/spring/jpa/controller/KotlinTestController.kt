package com.spring.jpa.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


fun main() {

}



@RestController
class KotlinTestController {


    @RequestMapping("/kotlin")
    fun test(): String {
        return "kotlin"
    }


}