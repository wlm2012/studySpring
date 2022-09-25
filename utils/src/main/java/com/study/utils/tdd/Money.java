package com.study.utils.tdd;

public abstract class Money {

    protected int amount;

    public static Dollar dollar(int amount) {
        return new Dollar(amount);
    }

    public static Franc franc(int amount) {
        return new Franc(amount);
    }

    abstract Money time(int time);

    public boolean equals(Object object) {
        if (null != object && !getClass().equals(object.getClass())) {
            return false;
        }

        if (object instanceof Money money) {
            return amount == money.amount;
        } else {
            return false;
        }
    }

    abstract String currency();
}
