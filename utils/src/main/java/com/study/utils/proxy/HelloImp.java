package com.study.utils.proxy;

public class HelloImp implements HelloInterfacce {
    @Override
    public int cost(String id) {
        System.out.println("返回价格 " + id);
        return Integer.parseInt(id);
    }

    @Override
    public void print(String name, int id) {
        System.out.println("print " + name + " id " + id);
    }
}
