package com.study.utils.concurrency.asynProgramming._2;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.scheduling.annotation.Async;

import java.util.PrimitiveIterator;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class SyncExampleTest {


    private final int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
            AVALIABLE_PROCESSORS * 2, 1,
            TimeUnit.MINUTES, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());


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
    void asyncLambda() throws InterruptedException {
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

    @Test
    void async() throws InterruptedException {
        long start = System.currentTimeMillis();
        Thread thread = new Thread("threadA") {
            public void run() {
                SyncExample.doSomethingA();
            }
        };

        thread.start();
        SyncExample.doSomethingB();
        thread.join();
        System.out.println(System.currentTimeMillis() - start);
    }


    @Test
    void threadPoolExecutor() throws InterruptedException {

        long start = System.currentTimeMillis();
        threadPoolExecutor.execute(SyncExample::doSomethingA);
        SyncExample.doSomethingB();
        System.out.println(System.currentTimeMillis() - start);
        Thread.currentThread().join();

    }

    @Test
    void executorSubmit() throws ExecutionException, InterruptedException {
        Future<?> future = threadPoolExecutor.submit(SyncExample::returnA);

        System.out.println("future = " + future.get());
    }


}