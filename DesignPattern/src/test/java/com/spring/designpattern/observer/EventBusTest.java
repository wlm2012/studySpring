package com.spring.designpattern.observer;

import com.spring.designpattern.observer.eventBus.CarObserver;
import com.spring.designpattern.observer.eventBus.EventController;
import com.spring.designpattern.observer.eventBus.UserObserver;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class EventBusTest {

    @Test
    public void eventTest() throws InterruptedException {
        EventController eventController = new EventController();
        ArrayList<Object> observers = new ArrayList<>();
        observers.add(new UserObserver());
        observers.add(new CarObserver());
        eventController.setRegObservers(observers);
        eventController.send();
    }
}
