package com.study.utils.tdd;

public class Dollar extends Money{


    public Dollar(int amount) {
        this.amount = amount;
    }


    public Dollar time(int time) {
        return new Dollar(amount * time);
    }



}
