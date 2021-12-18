package com.studyspring.diveinspringboot.configuration;

import org.springframework.context.annotation.Bean;

public class HelloWorldConfiguration {

    @Bean
    public String hello() {
        return "hello 2021";
    }
}
