package com.study.utils.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrancTest {

    @Test
    void test_multiplication() {
        Franc five = Money.franc(5);
        assertEquals(Money.franc(10), five.time(2));
        assertEquals(Money.franc(15), five.time(3));
    }

    @Test
    void test_equality() {
        Franc five = Money.franc(5);
        assertEquals(five, Money.franc(5));
        assertNotEquals(five, Money.franc(6));
        assertNotEquals(five, null);

    }

}
