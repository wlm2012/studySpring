package com.study.moocwiki.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class asyncTestController {

    @RequestMapping("/asyncTest")
    public void test() throws InterruptedException {

        log.info("0");
        Thread.sleep(1000);
        log.info("1");
        Thread.sleep(2*1000);
        log.info("2");
    }

}
