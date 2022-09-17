package com.spring.jpa.controller;

import com.spring.jpa.domain.entity.DogEntity;
import com.spring.jpa.service.impl.DogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
public class AsyncController {

    @Resource
    private DogService dogService;

    @RequestMapping("/asyncTest")
    public void asyncTest() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();

        CompletableFuture<DogEntity> future1 = dogService.asyncTest(new DogEntity(1L));
        CompletableFuture<DogEntity> future2 = dogService.asyncTest(new DogEntity(2L));
        CompletableFuture<DogEntity> future3 = dogService.asyncTest(new DogEntity(3L));

        //由于新的线程没有执行完任务，导致没有成功获取到dog，空指针异常
//        Dog dog = dogService.asyncTest1(new Dog(4L));
//        log.info(dog.toString());

        log.info("Elapsed time1: " + (System.currentTimeMillis() - start));

        CompletableFuture<Object> future4 = CompletableFuture.anyOf(future1, future2);
        log.info(future4.get().toString());

        log.info(future1.get().toString());
        log.info(future2.get().toString());
        log.info(future3.get().toString());
        log.info("Elapsed time2: " + (System.currentTimeMillis() - start));
    }

    @RequestMapping("/asyncTest1")
    public void asyncTest1() throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        List<CompletableFuture<DogEntity>> list = new ArrayList<>();
        for (long i = 0; i < 10_000; i++) {
            list.add(dogService.asyncTest(new DogEntity(i)));
            log.info("asyncTest1--=  " + i);
        }

        log.info("asyncTest1---" + list.size());
        log.info("Elapsed time1: " + (System.currentTimeMillis() - start));
        log.info(list.get(0).get().toString());
        log.info("Elapsed time2: " + (System.currentTimeMillis() - start));
        log.info(list.get(9999).get().toString());
        log.info("Elapsed time3: " + (System.currentTimeMillis() - start));
    }

}
