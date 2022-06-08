package com.spring.designpattern.observer.springEvent;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserEventController {

    private final UserEventPublisherService userEventPublisherService;


    @RequestMapping("/event")
    public void event(String name) {
        userEventPublisherService.register(name);
    }
}
