package com.spring.jpa.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;
import java.util.Random;

public class MyAuditorAware implements AuditorAware<Integer> {
    @Override
    public Optional<Integer> getCurrentAuditor() {
        Random random = new Random();
        int i = random.nextInt(100);
        return Optional.of(i);
    }
}
