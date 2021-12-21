package com.studyspring.diveinspringboot.springApplication.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.HIGHEST_PRECEDENCE)
public class HelloWorldApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("HelloWorldApplicationListener: " + event.getApplicationContext().getId()
                + "  ,timestamp:" + event.getTimestamp());
    }
}
