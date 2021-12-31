package com.spring.designpattern.observer;

public class ObserverDemo {

    public static void observer(){
        ConcreteSubject concreteSubject = new ConcreteSubject();
        concreteSubject.registerObserver(new ConcreteObserverOne());
        concreteSubject.registerObserver(new ConcreteObserverTwo());
        concreteSubject.notifyObservers(new Message("999"));
    }
}
