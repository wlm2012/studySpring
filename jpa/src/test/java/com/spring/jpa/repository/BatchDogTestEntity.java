package com.spring.jpa.repository;


import com.github.javafaker.Faker;
import com.github.javafaker.Number;
import com.spring.jpa.domain.entity.DogEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@SpringBootTest
public class BatchDogTestEntity {

    @Resource
    private DogRepository dogRepository;

    @Test
    public void batch() {
        Faker faker = new Faker(new Locale("zh-CN"));
        List<DogEntity> dogEntities = new ArrayList<>();
        com.github.javafaker.Dog dog = faker.dog();
        Number number = faker.number();
        for (int i = 0; i < 10_000; i++) {
            DogEntity build = DogEntity.builder().age(number.numberBetween(0, 20)).name(dog.name()).build();
            dogEntities.add(build);
        }
        long startTime = System.currentTimeMillis();
        dogRepository.saveAll(dogEntities);
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
