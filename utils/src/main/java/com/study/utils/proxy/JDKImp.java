package com.study.utils.proxy;

import java.util.Random;

public class JDKImp implements JDKInterfacce {
    @Override
    public int cost(String id) {
        System.out.println("返回价格 " + id);
        return Integer.parseInt(id);
    }

    @Override
    public void print(String name, int id) {
        System.out.println("print " + name + " id " + id);
    }

    @Override
    public int random() {
        Random random = new Random();
        int i = random.nextInt(100);
        System.out.println(i);
        return i;
    }
}
