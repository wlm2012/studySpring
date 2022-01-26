package com.spring.designpattern.observer.springEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserEventPublisherService {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public UserEventPublisherService(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void register(String name) {
        System.out.println("UserEventPublisherService = " + System.currentTimeMillis());
        applicationEventPublisher.publishEvent(new UserRegisterEvent(name));
        System.out.println("UserEventPublisherService = " + System.currentTimeMillis());
    }
}
