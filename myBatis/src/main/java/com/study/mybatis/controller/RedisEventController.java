package com.study.mybatis.controller;

import com.study.mybatis.DO.TDog;
import com.study.mybatis.mapper.TDogMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.stream.ObjectRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.connection.stream.StreamRecords;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RedisEventController {

    @Value("${stream.key}")
    private String streamKey;

    private final TDogMapper tDogMapper;

    private final RedisTemplate<String, String> redisTemplate;


    public RedisEventController(TDogMapper tDogMapper, RedisTemplate<String, String> redisTemplate) {
        this.tDogMapper = tDogMapper;
        this.redisTemplate = redisTemplate;
    }

    @RequestMapping("/eventRedis")
    public void eventRedis(String name) {
        TDog tDog = new TDog();
        tDog.setName(name);
        List<TDog> tDogs = tDogMapper.selective(tDog);

        for (TDog dog : tDogs) {
            ObjectRecord<String, TDog> dogObjectRecord = StreamRecords.newRecord()
                    .ofObject(dog)
                    .withStreamKey(streamKey);

            redisTemplate.opsForStream()
                    .add(dogObjectRecord);
        }
    }
}
