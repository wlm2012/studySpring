package com.spring.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@Profile("hello")
public class Tut1Config {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }




}
