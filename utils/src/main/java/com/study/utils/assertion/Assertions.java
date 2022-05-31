package com.study.utils.assertion;

public class Assertions {

    public static void main(String[] args) {
        double x = Math.abs(-123.45);
        // 需要改变编译参数
        assert x < 0;
        System.out.println(x);
    }
}
