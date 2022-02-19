package com.spring.rabbitmq.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

public class Tut1Sender {

    @Resource
    private Queue hello;

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World!";
        rabbitTemplate.convertAndSend(hello.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
