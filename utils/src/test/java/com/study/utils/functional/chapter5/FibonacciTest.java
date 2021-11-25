package com.study.utils.functional.chapter5;

import org.junit.jupiter.api.Test;

public class FibonacciTest {

    @Test
    public void test() {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacci(10));

    }
}
