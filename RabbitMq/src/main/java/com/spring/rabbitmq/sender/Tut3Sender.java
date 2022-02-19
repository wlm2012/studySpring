package com.spring.rabbitmq.sender;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Tut3Sender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private FanoutExchange fanoutExchange;

    AtomicInteger dots = new AtomicInteger(0);

    AtomicInteger count = new AtomicInteger(0);

    @Scheduled(fixedDelay = 1000, initialDelay = 5000)
    public void send() {
        StringBuilder builder = new StringBuilder("Hello");
        if (dots.getAndIncrement() == 3) {
            dots.set(1);
        }
        builder.append(".".repeat(Math.max(0, dots.get())));

        builder.append(count.incrementAndGet());
        String message = builder.toString();
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", message);
        log.info(" {} Sent ", "'" + message + "'");
    }
}
