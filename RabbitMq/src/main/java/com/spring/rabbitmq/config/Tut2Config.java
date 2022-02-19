package com.spring.rabbitmq.config;

import com.spring.rabbitmq.receiver.Tut2Receiver;
import com.spring.rabbitmq.sender.Tut2Sender;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("work-queues")
@Configuration
public class Tut2Config {

    @Bean
    public Queue workQueues() {
        return new Queue("work-queues");
    }

    @Bean
    public Tut2Receiver receiver1() {
        return new Tut2Receiver(1);
    }

    @Bean
    public Tut2Receiver receiver2() {
        return new Tut2Receiver(2);
    }

    @Bean
    public Tut2Sender sender() {
        return new Tut2Sender();
    }


}
