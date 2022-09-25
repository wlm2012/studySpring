package com.study.utils.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrancTest {

    @Test
    void test_multiplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.time(2));
        assertEquals(new Franc(15), five.time(3));
    }

    @Test
    void test_equality() {
        Franc five = new Franc(5);
        assertEquals(five, new Franc(5));
        assertNotEquals(five, new Franc(6));
        assertNotEquals(five, null);

    }

}
