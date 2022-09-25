package com.study.utils.tdd;

public class Money {

    protected int amount;

    public boolean equals(Object object) {
        if (object instanceof Money money) {
            return amount == money.amount;
        } else {
            return false;
        }
    }
}
