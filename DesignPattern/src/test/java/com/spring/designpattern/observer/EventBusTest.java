package com.spring.designpattern.observer;

import com.spring.designpattern.observer.eventBus.EventController;
import org.junit.jupiter.api.Test;

public class EventBusTest {

    @Test
    public void eventTest() throws InterruptedException {
        EventController eventController = new EventController();
        eventController.eventTest();
    }
}
