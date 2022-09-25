package com.study.utils.tdd;

public class Franc {

    public Franc(int amount) {
        this.amount = amount;
    }

    private final int amount;

    public Franc time(int time) {
        return new Franc(amount * time);
    }

    public boolean equals(Object object) {
        if (object instanceof Franc franc) {
            return amount == franc.amount;
        } else {
            return false;
        }
    }
}
