package com.spring.designpattern.observer.springEvent;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEventPublisherService {

    private final ApplicationEventPublisher applicationEventPublisher;


    public void register(String name) {
        System.out.println("UserEventPublisherService = " + System.currentTimeMillis());
        applicationEventPublisher.publishEvent(new UserRegisterEvent(name));
        System.out.println("UserEventPublisherService = " + System.currentTimeMillis());
    }
}
