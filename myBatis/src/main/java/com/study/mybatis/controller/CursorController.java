package com.study.mybatis.controller;

import com.study.mybatis.DO.TDog;
import com.study.mybatis.mapper.TDogMapper;
import org.apache.ibatis.cursor.Cursor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class CursorController {

    private final TDogMapper tDogMapper;
    private final AsyncController asyncController;

    public CursorController(TDogMapper tDogMapper, AsyncController asyncController) {
        this.tDogMapper = tDogMapper;
        this.asyncController = asyncController;
    }

    @Transactional
    @RequestMapping("/cursor")
    public void test() {
        Cursor<TDog> tDogs = tDogMapper.selectCursor();
        List<TDog> dogs = new ArrayList<>();
        Iterator<TDog> iterator = tDogs.iterator();
        for (int i = 0; i < 1000; i++) {
            TDog next = iterator.next();
            dogs.add(next);
        }
        System.out.println("dogs.size() = " + dogs.size());
        asyncController.insertAll(dogs);

        dogs = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            TDog next = iterator.next();
            dogs.add(next);
        }
        System.out.println("dogs.size() = " + dogs.size());
        asyncController.insertAll(dogs);

        TDog tDog = dogs.get(999);
        System.out.println("tDog = " + tDog);
    }

    @Transactional
    @RequestMapping("/cursor1")
    public void cursor1() {
        long startTime = System.currentTimeMillis();
        Cursor<TDog> tDogs = tDogMapper.selectCursor();
        List<TDog> dogs = new ArrayList<>();
        List<CompletableFuture<Integer>> completableFutureList = new ArrayList<>();
        for (TDog next : tDogs) {
            dogs.add(next);
            if (dogs.size() == 1000) {
                CompletableFuture<Integer> integerCompletableFuture = asyncController.insertAll(dogs);
                completableFutureList.add(integerCompletableFuture);
                dogs = new ArrayList<>();
            }
        }

        for (CompletableFuture<Integer> integerCompletableFuture : completableFutureList) {
            Integer join = integerCompletableFuture.join();
            System.out.println("join = " + join);
        }
        System.out.println("System.currentTimeMillis()-startTime = " + (System.currentTimeMillis() - startTime));
        throw new RuntimeException("rollback");
    }

    @Transactional
    @RequestMapping("/cursor2")
    public void cursor2() {
        List<TDog> dogs = new ArrayList<>();
        Cursor<TDog> tDogs = tDogMapper.selectCursor();
        Iterator<TDog> iterator = tDogs.iterator();
        for (int i = 0; i < 1000; i++) {
            TDog next = iterator.next();
            dogs.add(next);
        }
        System.out.println("dogs.size() = " + dogs.size());


        dogs = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            TDog next = iterator.next();
            dogs.add(next);
        }
        System.out.println("dogs.size() = " + dogs.size());

        TDog tDog = dogs.get(999);
        System.out.println("tDog = " + tDog);
    }

}
