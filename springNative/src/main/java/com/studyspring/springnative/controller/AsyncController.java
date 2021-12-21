package com.studyspring.springnative.controller;

import com.studyspring.springnative.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
public class AsyncController {

    private AsyncService asyncService;

    @Autowired
    public AsyncController(AsyncService asyncService) {
        this.asyncService = asyncService;
    }


    @RequestMapping("/asyncTest")
    public void test() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        CompletableFuture<Integer> tset = asyncService.tset(1);
        CompletableFuture<Integer> tset1 = asyncService.tset(2);
        CompletableFuture<Integer> tset2 = asyncService.tset(3);

        log.info("Elapsed time1: " + (System.currentTimeMillis() - start));

        CompletableFuture<Object> future4 = CompletableFuture.anyOf(tset, tset1);
        log.info(future4.get().toString());

        log.info(tset.get().toString());
        log.info(tset1.get().toString());
        log.info(tset2.get().toString());
        log.info("Elapsed time2: " + (System.currentTimeMillis() - start));


    }
}
