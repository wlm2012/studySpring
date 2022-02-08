package com.study.mybatis.service;


import com.study.mybatis.DO.TDog;
import com.study.mybatis.mapper.TDogMapper;
import lombok.SneakyThrows;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TdogEventConsumer implements StreamListener<String, ObjectRecord<String, TDog>> {

    private final TDogMapper tDogMapper;

    public TdogEventConsumer(TDogMapper tDogMapper) {
        this.tDogMapper = tDogMapper;
    }


    @SneakyThrows
    @Override
    public void onMessage(ObjectRecord<String, TDog> message) {
        System.out.println("message.getId() = " + message.getId());
        System.out.println("message.getStream() = " + message.getStream());
        System.out.println("message.getValue() = " + message.getValue());
        TimeUnit.SECONDS.sleep(1L);
        tDogMapper.insert1(message.getValue());
    }
}
