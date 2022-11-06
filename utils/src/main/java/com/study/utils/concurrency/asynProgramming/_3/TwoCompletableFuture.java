package com.study.utils.concurrency.asynProgramming._3;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class TwoCompletableFuture {

    public static CompletableFuture<String> doSomethingOne(String encodedCompanyId) {
        return CompletableFuture
                .completedFuture(encodedCompanyId)
                .thenApplyAsync(t -> {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return t;
                });
    }

    public static CompletableFuture<String> doSomethingTwo(String companyId) {
        return CompletableFuture
                .completedFuture(companyId)
                .thenApplyAsync(t -> {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return t + ":alibaba";
                });
    }

    public static CompletableFuture<Integer> exception(Integer integer) {
        CompletableFuture<Integer> future = new CompletableFuture<>();
        new Thread(() -> {
            if (integer > 0) {
                throw new RuntimeException("excetion test");
            }
            future.complete(integer);
            System.out.println("----" + Thread.currentThread().getName() + " set future result----");
        }, "thread-1").start();
        return future;
    }
}
