package com.study.utils.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SchedulingTest {

    //    @Scheduled(cron = "0/5 * * * * ? ")
    public void test1() throws InterruptedException {
        log.info("test1  ");
        Thread.sleep(18000);
    }

    //    @Scheduled(cron = "0/6 * * * * ? ")
    public void test2() {
        log.info("test2  ");
    }
}
