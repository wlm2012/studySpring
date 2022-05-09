package com.study.utils.round;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    private static Calc calc;

    @BeforeAll
    static void init() {
        calc = new Calc();
    }

    @Test
    void test() {
        calc.test();
    }

    @Test
    void test1() {
        calc.test1();
    }

    @Test
    void test2(){
        calc.test2();
    }

}