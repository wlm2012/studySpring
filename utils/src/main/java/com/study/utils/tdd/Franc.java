package com.study.utils.tdd;

public class Franc extends Money {

    public Franc(int amount, String currency) {
        super(amount, currency);
    }


    public Money time(int time) {
        return Money.franc(amount * time);
    }


}
