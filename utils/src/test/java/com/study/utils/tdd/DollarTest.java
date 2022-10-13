package com.study.utils.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DollarTest {

    @Test
    void test_multiplication() {
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.time(2));
        assertEquals(Money.dollar(15), five.time(3));
    }

    @Test
    void test_equality() {
        Money five = Money.dollar(5);
        assertEquals(five, Money.dollar(5));
        assertNotEquals(five, Money.dollar(6));
        assertNotEquals(five, null);

        assertNotEquals(five, Money.franc(5));

    }


    @Test
    void test_currency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    void test_simple_addition() {
        Expression sum = Money.dollar(3).plus(Money.dollar(4));
        Bank bank = new Bank();
        Money reduce = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), reduce);
    }

    @Test
    void test_plus_return_sum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.addend);
        assertEquals(five, sum.augend);
    }

    @Test
    void test_reduce_money(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

}