package com.study.utils.tdd;

public class Bank {
    public Money reduce(Expression source, String to) {
        if (source instanceof Money money) {
            return money.reduce(to);
        }

        Sum sum = (Sum) source;
        return sum.reduce(to);
    }
}
