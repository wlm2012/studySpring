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

@RestController
public class CursorController {

    private final TDogMapper tDogMapper;

    public CursorController(TDogMapper tDogMapper) {
        this.tDogMapper = tDogMapper;
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

        for (int i = 0; i < 1000; i++) {
            TDog next = iterator.next();
            dogs.add(next);
        }
        System.out.println("dogs.size() = " + dogs.size());

        TDog tDog = dogs.get(1999);
        System.out.println("tDog = " + tDog);
    }
}
