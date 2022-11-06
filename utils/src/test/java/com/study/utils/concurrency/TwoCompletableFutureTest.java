package com.study.utils.concurrency;

import com.study.utils.concurrency.asynProgramming._3.TwoCompletableFuture;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TwoCompletableFutureTest {


    @Test
    void thenCompose() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<String> future = TwoCompletableFuture.doSomethingOne("123")
                .thenCompose(TwoCompletableFuture::doSomethingTwo);

        System.out.println(System.currentTimeMillis() - start);
        System.out.println("future = " + future.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    void thenCombine() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        CompletableFuture<String> future = TwoCompletableFuture.doSomethingOne("123")
                .thenCombine(TwoCompletableFuture.doSomethingTwo("456"),
                        (one, two) -> one + " " + two);

        System.out.println(System.currentTimeMillis() - start);
        System.out.println("future = " + future.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    void allOf() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<CompletableFuture<String>> futureList = new ArrayList<>();
        futureList.add(TwoCompletableFuture.doSomethingOne("1"));
        futureList.add(TwoCompletableFuture.doSomethingOne("2"));
        futureList.add(TwoCompletableFuture.doSomethingOne("3"));
        futureList.add(TwoCompletableFuture.doSomethingOne("4"));

        CompletableFuture[] completableFutures = futureList.toArray(new CompletableFuture[0]);
        System.out.println("completableFutures.length = " + completableFutures.length);
        CompletableFuture<Void> result = CompletableFuture.allOf(completableFutures);
        System.out.println(result.get());
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    void anyOf() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        List<CompletableFuture<String>> futureList = new ArrayList<>();
        futureList.add(TwoCompletableFuture.doSomethingOne("1"));
        futureList.add(TwoCompletableFuture.doSomethingOne("2"));
        futureList.add(TwoCompletableFuture.doSomethingTwo("3"));

        CompletableFuture<Object> result = CompletableFuture
                .anyOf(futureList.toArray(new CompletableFuture[0]));
        System.out.println(result.get());
        System.out.println(System.currentTimeMillis() - start);
    }


}
