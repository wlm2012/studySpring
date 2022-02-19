package com.spring.rabbitmq.config;

import com.spring.rabbitmq.receiver.Tut1Receiver;
import com.spring.rabbitmq.sender.Tut1Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("hello")
@Configuration
public class Tut1Config {

    @Bean
    public Queue hello() {
        return new Queue("hello");
    }


    @Bean
    public Tut1Sender tut1Sender() {
        return new Tut1Sender();
    }

    @Bean
    public Tut1Receiver tut1Receiver() {
        return new Tut1Receiver();
    }


}
