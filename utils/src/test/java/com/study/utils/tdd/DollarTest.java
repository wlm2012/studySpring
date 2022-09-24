package com.study.utils.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {

    @Test
    void test_multiplication() {
        Dollar five = new Dollar(5);
        Dollar product = five.time(2);
        assertEquals(10, product.amount);
        product = five.time(3);
        assertEquals(15, product.amount);
    }

}