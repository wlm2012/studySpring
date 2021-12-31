package com.spring.designpattern.observer.eventBus;

import com.google.common.eventbus.Subscribe;
import com.spring.designpattern.observer.eventBus.event.EventA;
import com.spring.designpattern.observer.eventBus.event.EventB;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class UserObserver {

    @Subscribe
    public void printA(EventA eventA) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info("printA   " + eventA.name());
    }

    @Subscribe
    public void printB(EventB eventB) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info("printB   " + eventB.id());
    }
}
