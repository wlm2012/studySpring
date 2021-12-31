package com.spring.designpattern.observer;

public class ConcreteObserverTwo implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverTwo: " + message.getMessage());
    }
}
