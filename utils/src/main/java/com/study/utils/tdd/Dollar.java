package com.study.utils.tdd;

public class Dollar {


    public Dollar(int amount) {
        this.amount = amount;
    }

    private final int amount;

    public Dollar time(int time) {
        return new Dollar(amount * time);
    }

    public boolean equals(Object object) {
        if (object instanceof Dollar dollar) {
            return amount == dollar.amount;
        } else {
            return false;
        }
    }

}
