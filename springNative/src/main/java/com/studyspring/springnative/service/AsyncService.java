package com.studyspring.springnative.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class AsyncService {

    @Async
    public CompletableFuture<Integer> tset(Integer integer) throws InterruptedException {
        System.out.println(integer);
        TimeUnit.SECONDS.sleep(integer);
        return CompletableFuture.completedFuture(integer);
    }
}
