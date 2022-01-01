package com.spring.designpattern.observer.eventBus;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.spring.designpattern.observer.eventBus.event.EventA;
import com.spring.designpattern.observer.eventBus.event.EventB;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Slf4j
public class EventController {

    private final EventBus eventBus;

    private static final int DEFAULT_EVENTBUS_THREAD_POOL_SIZE = 20;

    public EventController() {
        ExecutorService executor = new ThreadPoolExecutor(5, 10,
                60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(DEFAULT_EVENTBUS_THREAD_POOL_SIZE),
                new ThreadPoolExecutor.CallerRunsPolicy());
//        executor=Executors.newSingleThreadExecutor();
        eventBus = new AsyncEventBus(executor);
    }

    public void setRegObservers(List<Object> observers) {
        for (Object observer : observers) {
            eventBus.register(observer);
        }
    }

    public void send() throws InterruptedException {
        log.info("------------send  EventA");
        eventBus.post(new EventA("996"));
        log.info("------------EventB");
        eventBus.post(new EventB(123));
        TimeUnit.SECONDS.sleep(5);
    }

}
