package com.spring.designpattern.observer.springEvent;

import org.springframework.context.ApplicationEvent;

public class UserRegisterEvent extends ApplicationEvent {

    public UserRegisterEvent(String source) {
        super(source);
    }
}
