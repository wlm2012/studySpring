package com.study.utils.config;

import com.study.utils.controller.SchedulingTest;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class ScheduledConfig {

    @Resource
    private ThreadPoolTaskScheduler taskScheduler;

    @Resource
    private SchedulingTest schedulingTest;


    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(5);
        taskScheduler.setThreadNamePrefix("task-");
        return taskScheduler;
    }

    @PostConstruct
    public void addTask() {
        taskScheduler.scheduleWithFixedDelay(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                schedulingTest.test1();
            }
        }, 1000L);

        taskScheduler.scheduleWithFixedDelay(() -> schedulingTest.test2(), 2000L);
    }
}
