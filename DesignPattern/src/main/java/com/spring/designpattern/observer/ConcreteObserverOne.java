package com.spring.designpattern.observer;

public class ConcreteObserverOne implements Observer {
    @Override
    public void update(Message message) {
        System.out.println("ConcreteObserverOne: " + message.getMessage());
    }
}
