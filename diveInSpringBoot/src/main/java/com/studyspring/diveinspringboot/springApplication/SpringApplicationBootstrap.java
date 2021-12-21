package com.studyspring.diveinspringboot.springApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

public class SpringApplicationBootstrap {

    public static void main(String[] args) {
        //修改为set方式
//        SpringApplication.run(ApplicationConfiguration.class, args);
        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(Set.of(ApplicationConfiguration.class.getName()));
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
