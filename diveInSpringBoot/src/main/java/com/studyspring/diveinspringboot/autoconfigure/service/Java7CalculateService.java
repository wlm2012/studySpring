package com.studyspring.diveinspringboot.autoconfigure.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


@Service
@Profile("java7")
public class Java7CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        System.out.println("java 7");
        int sum = 0;
        for (int i : values) {
            sum += i;
        }
        return sum;
    }
}
