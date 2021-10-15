package com.study.utils.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class SchedulingTest {

//    @Scheduled(cron = "0/5 * * * * ? ")
    public void test1() throws InterruptedException {
        LocalDateTime now = LocalDateTime.now();
        log.info("test1  " + now);
        Thread.sleep(18000);
    }

//    @Scheduled(cron = "0/6 * * * * ? ")
    public void test2() {
        LocalDateTime now = LocalDateTime.now();
        log.info("test2  " + now);
    }
}
