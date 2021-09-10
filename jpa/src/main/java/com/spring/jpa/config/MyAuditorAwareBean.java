package com.spring.jpa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAuditorAwareBean {

    @Bean
    public MyAuditorAware myAuditorAware() {
        return new MyAuditorAware();
    }
}
