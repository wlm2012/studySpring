package com.study.utils.concurrency;

import com.study.utils.concurrency.asynProgramming._2.SyncExample;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class FutureTaskServiceImplTest {


    private final int AVALIABLE_PROCESSORS = Runtime.getRuntime().availableProcessors();
    private final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(AVALIABLE_PROCESSORS,
            AVALIABLE_PROCESSORS * 2, 1,
            TimeUnit.MINUTES, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.CallerRunsPolicy());

    @Test
    void asyncFutureTask() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        FutureTask<String> futureTask = new FutureTask<>(SyncExample::returnA);
        Thread thread = new Thread(futureTask, "threadA");
        thread.start();

        String returnB = SyncExample.returnB();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("returnB = " + returnB);

        String taskAResult = futureTask.get();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("taskAResult = " + taskAResult);
    }

    @Test
    void asyncPool() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        FutureTask<String> futureTask = new FutureTask<>(SyncExample::returnA);
        threadPoolExecutor.execute(futureTask);

        String returnB = SyncExample.returnB();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("returnB = " + returnB);

        String taskAResult = futureTask.get();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("taskAResult = " + taskAResult);
    }

    @Test
    void asyncPool1() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        Future<String> future = threadPoolExecutor.submit(SyncExample::returnA);

        String returnB = SyncExample.returnB();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("returnB = " + returnB);

        String taskAResult = future.get();
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("taskAResult = " + taskAResult);
    }





}