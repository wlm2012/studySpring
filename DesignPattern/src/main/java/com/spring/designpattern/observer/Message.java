package com.spring.designpattern.observer;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class Message {
    String message;

    public Message(String message) {
        this.message = message;
    }
}
