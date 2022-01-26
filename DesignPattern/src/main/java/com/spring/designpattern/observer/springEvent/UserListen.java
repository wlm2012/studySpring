package com.spring.designpattern.observer.springEvent;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class UserListen {

    @Async
    @EventListener
    public void listenUserRegisterEvent(UserRegisterEvent event) throws InterruptedException {
        System.out.println("event.getTimestamp() = " + event.getTimestamp());
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        Thread.sleep(5000);
        System.out.println(event.getSource());
        System.out.println("event.getTimestamp() = " + event.getTimestamp());
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
    }
}
