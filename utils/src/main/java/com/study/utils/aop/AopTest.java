package com.study.utils.aop;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AopTest {

    @RequestMapping("/aop")
    public String test(String name) {
        System.out.println(name);
        return name + " : " + System.currentTimeMillis();
    }

    @AopAnnotation
    @RequestMapping("/aopAnnotation")
    public Integer aopAnnotation(String num) {
        Integer integer = Integer.valueOf(num);
        System.out.println("integer = " + integer);
        return integer;
    }
}
