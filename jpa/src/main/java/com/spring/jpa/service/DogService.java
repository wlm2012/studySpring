package com.spring.jpa.service;

import com.spring.jpa.DO.Dog;
import com.spring.jpa.repository.DogRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Service
public class DogService {

    @Resource
    private DogRepository dogRepository;

    @Async
    public CompletableFuture<Dog> asyncTest(Dog dog) throws InterruptedException {
        Random random = new Random(dog.getNum());
        dog.setAge(random.nextInt(100));
        dog = dogRepository.save(dog);
        Thread.sleep(dog.getNum() * 10_000);
        return CompletableFuture.completedFuture(dog);
    }

    @Async
    public Dog asyncTest1(Dog dog) throws InterruptedException {
        Random random = new Random(dog.getNum());
        dog.setAge(random.nextInt(100));
        dog = dogRepository.save(dog);
        Thread.sleep(dog.getNum() * 10_000);
        return dog;
    }
}
