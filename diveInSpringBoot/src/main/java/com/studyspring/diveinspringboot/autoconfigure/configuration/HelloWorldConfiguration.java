package com.studyspring.diveinspringboot.autoconfigure.configuration;

import org.springframework.context.annotation.Bean;

public class HelloWorldConfiguration {

    @Bean
    public String hello() {
        return "hello 2021";
    }
}
