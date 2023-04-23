package com.study.javaconcurrencyinpractice.threadPool;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class TenCoreThreadTest {

    @Test
    void test() throws ExecutionException, InterruptedException {
        // 线程的第一个任务是直接分配的，后来的任务会加入队列后，从队列中获取，
        // 如果队列过短，加入的任务过快，获取任务的速度过慢，队列满了后，再加入任务，导致提交任务后引发拒绝策略

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(30, 30, 10, TimeUnit.SECONDS, new LinkedBlockingQueue<>(2));
        //todo 待测试，如果先启动了核心线程，是否会导致线程的第一任务需要先加入队列，而不是直接分给线程
        // todo 还是需要看源码
        threadPoolExecutor.prestartCoreThread();
        ExecutorCompletionService<Integer> service = new ExecutorCompletionService<>(threadPoolExecutor);


        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < 30; i++) {
                int finalI = i;
                System.out.println("submit " + j + "  " + finalI);
                service.submit(() -> {
                    Thread.sleep(3000);
                    return finalI;
                });
            }

            for (int i = 0; i < 30; i++) {
                Future<Integer> future = service.take();
                System.out.println("future   " + future.get());
            }
            System.out.println(" finish ");
        }
    }
}
