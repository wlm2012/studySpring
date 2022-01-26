package com.spring.designpattern.observer.springEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserEventController {

    private final UserEventPublisherService userEventPublisherService;

    @Autowired
    public UserEventController(UserEventPublisherService service) {
        userEventPublisherService = service;
    }

    @RequestMapping("/event")
    public void event(String name) {
        userEventPublisherService.register(name);
    }
}
