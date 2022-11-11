package com.spring.jpa.service.impl;

import com.spring.jpa.domain.entity.DogEntity;
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
    public CompletableFuture<DogEntity> asyncTest(DogEntity dogEntity) throws InterruptedException {
        Random random = new Random(dogEntity.getNum());
        dogEntity.setAge(random.nextInt(100));
        dogEntity = dogRepository.save(dogEntity);
        Thread.sleep(dogEntity.getNum() * 10_000);
        return CompletableFuture.completedFuture(dogEntity);
    }





}
