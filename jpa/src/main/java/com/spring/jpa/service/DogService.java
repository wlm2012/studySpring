package com.spring.jpa.service;

import com.spring.jpa.DO.Dog;
import com.spring.jpa.repository.DogRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

@Service
public class DogService {

    @Resource
    private DogRepository dogRepository;

    @Async
    public void asyncTest(Dog dog) throws InterruptedException {
        Random random = new Random(dog.getId());
        dog.setAge(random.nextInt(100));
        dogRepository.save(dog);
        Thread.sleep(1_000);
    }
}
