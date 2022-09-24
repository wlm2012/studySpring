package com.study.utils.tdd;

public class Dollar {


    public Dollar(int amount) {
        this.amount = amount;
    }

    public int amount;

    public Dollar time(int time) {
        return new Dollar(amount * time);
    }

}
