package com.study.utils.tdd;

public class Dollar extends Money{


    public Dollar(int amount) {
        this.amount = amount;
    }


    public Money time(int time) {
        return new Dollar(amount * time);
    }

    @Override
    String currency() {
        return "USD";
    }


}
