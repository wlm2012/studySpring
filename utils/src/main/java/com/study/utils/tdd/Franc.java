package com.study.utils.tdd;

public class Franc extends Money {

    public Franc(int amount, String currency) {
        this.amount = amount;
        this.currency = "CHF";
    }


    public Money time(int time) {
        return Money.franc(amount * time);
    }


}
