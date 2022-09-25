package com.study.utils.tdd;

public abstract class Money {

    protected int amount;

    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Dollar dollar(int amount) {
        return new Dollar(amount, "USD");
    }

    public static Franc franc(int amount) {
        return new Franc(amount, "CHF");
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

    String currency() {
        return currency;
    }
}
