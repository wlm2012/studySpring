package com.study.utils.concurrency.asynProgramming._2;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.Async;

import static org.junit.jupiter.api.Assertions.*;

class SyncExampleTest {

    @Test
    void syncExample() {
        long start = System.currentTimeMillis();
        // 1.执行任务A
        SyncExample.doSomethingA();
        // 2.执行任务B
        SyncExample.doSomethingB();
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    void async() throws InterruptedException {
        long start = System.currentTimeMillis();
        // 1.开启异步单元执行任务A
        Thread thread = new Thread(() -> {
            try {
                SyncExample.doSomethingA();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "threadA");
        thread.start();
        // 2.执行任务B
        SyncExample.doSomethingB();
        // 3.同步等待线程A运行结束
        thread.join();
        System.out.println(System.currentTimeMillis() - start);
    }




}