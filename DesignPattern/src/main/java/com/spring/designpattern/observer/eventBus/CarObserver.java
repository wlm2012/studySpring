package com.spring.designpattern.observer.eventBus;

import com.google.common.eventbus.Subscribe;
import com.spring.designpattern.observer.eventBus.event.EventA;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class CarObserver {

    @Subscribe
    public void printCar(EventA eventA) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info("printCar  " + eventA.name());
    }
}
