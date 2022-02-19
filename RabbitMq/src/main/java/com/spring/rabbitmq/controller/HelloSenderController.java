package com.spring.rabbitmq.controller;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloSenderController {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private Queue hello;

    @RequestMapping("/hello")
    public void send(String message) {
        rabbitTemplate.convertAndSend(hello.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }

}
