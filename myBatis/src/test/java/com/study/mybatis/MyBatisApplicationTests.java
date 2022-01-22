package com.study.mybatis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class MyBatisApplicationTests {


    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public MyBatisApplicationTests(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Test
    public void redisTest() {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set("name", "123qwe");
    }

    @Test
    public void redisTest1() {
        ValueOperations<String, String> stringStringValueOperations = redisTemplate.opsForValue();
        String s = stringStringValueOperations.get("111");
        System.out.println("s = " + s);
    }

    @Test
    void contextLoads() {
    }


}
