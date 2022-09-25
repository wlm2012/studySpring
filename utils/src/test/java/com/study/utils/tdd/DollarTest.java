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
        Dollar five = Money.dollar(5);
        assertEquals(five, Money.dollar(5));
        assertNotEquals(five, Money.dollar(6));
        assertNotEquals(five, null);

        assertNotEquals(five, new Franc(5));

    }


    @Test
    void test_currency(){
        assertEquals("USD",Money.dollar(1).currency());
        assertEquals("CHF",Money.franc(1).currency());
    }

}