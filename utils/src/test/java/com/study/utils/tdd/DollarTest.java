package com.study.utils.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {

    @Test
    void test_multiplication() {
        Dollar five = new Dollar(5);
        assertEquals(new Dollar(10), five.time(2));
        assertEquals(new Dollar(15), five.time(3));
    }

    @Test
    void test_equality() {
        Dollar five = new Dollar(5);
        assertEquals(five, new Dollar(5));
        assertNotEquals(five, new Dollar(6));
        assertNotEquals(five, null);

    }

}