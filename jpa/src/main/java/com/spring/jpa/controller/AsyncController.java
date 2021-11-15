package com.spring.jpa.controller;

import com.spring.jpa.DO.Dog;
import com.spring.jpa.service.DogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AsyncController {

    @Resource
    private DogService dogService;

    @RequestMapping("/asyncTest")
    public void asyncTest() throws InterruptedException {
        for (long i = 0; i < 10_000; i++) {
            dogService.asyncTest(new Dog(i));
        }
    }

}
