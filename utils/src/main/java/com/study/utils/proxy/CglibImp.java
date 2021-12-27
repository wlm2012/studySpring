package com.study.utils.proxy;

import java.util.Random;

public class CglibImp {

    public Integer print(String id) {
        Integer integer = Integer.valueOf(id);
        System.out.println(integer);
        return integer;
    }

    public Integer random() {
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);
        return i;
    }
}
