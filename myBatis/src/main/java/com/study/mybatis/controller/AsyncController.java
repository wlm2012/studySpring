package com.study.mybatis.controller;

import com.study.mybatis.DO.TDog;
import com.study.mybatis.mapper.TDogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncController {

    private final TDogMapper tDogMapper;

    @Autowired
    public AsyncController(TDogMapper tDogMapper) {
        this.tDogMapper = tDogMapper;
    }


    @Async
    public CompletableFuture<Integer> insertAll(List<TDog> list) {
        int i = tDogMapper.insertAll(list);
        System.out.println("i = " + i);
        return CompletableFuture.completedFuture(i);
    }
}
