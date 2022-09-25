package com.study.utils.tdd;

public class Dollar extends Money {


    public Dollar(int amount, String currency) {
        super(amount, currency);
    }


    public Money time(int time) {
        return Money.dollar(amount * time);
    }


}
