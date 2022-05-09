package com.study.utils.stackTrace;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FunctionTest {

    private static Functions functions;

    @BeforeAll
    static void init() {
        functions = new Functions();
    }

    @Test
    void test() {
        functions.test();
    }

    @Test
    void test1() {
        functions.test1();
    }
}