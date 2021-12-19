package com.studyspring.diveinspringboot.springApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

public class SpringApplicationBootstrap {

    public static void main(String[] args) {
//        SpringApplication.run(ApplicationConfiguration.class, args);
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(Set.of(ApplicationConfiguration.class.getName()));
        springApplication.run(args);
    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
