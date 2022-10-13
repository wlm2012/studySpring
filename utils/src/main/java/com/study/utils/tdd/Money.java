package com.study.utils.tdd;

import java.util.Objects;

public class Money implements Expression {

    protected int amount;

    protected String currency;

    Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    Money time(int time) {
        return new Money(amount * time, currency);
    }

    public boolean equals(Object object) {
        if (null == object) {
            return false;
        }

        if (object instanceof Money money) {
            return amount == money.amount && Objects.equals(currency, money.currency);
        } else {
            return false;
        }
    }

    String currency() {
        return currency;
    }

    Sum plus(Money money) {
        return new Sum(this, money);
    }

    public Money reduce(String to) {
        return this;
    }
}
