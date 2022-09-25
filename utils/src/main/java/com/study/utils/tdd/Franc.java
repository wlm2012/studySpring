package com.study.utils.tdd;

public class Franc extends Money {

    public Franc(int amount) {
        this.amount = amount;
    }


    public Money time(int time) {
        return new Franc(amount * time);
    }

    @Override
    String currency() {
        return "CHF";
    }

}
