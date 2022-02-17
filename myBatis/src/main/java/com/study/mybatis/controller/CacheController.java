package com.study.mybatis.controller;

import com.study.mybatis.DO.TDog;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CacheController {

    @Resource
    private RedisCacheController redisCacheController;

    @RequestMapping("/cacheGet")
    public TDog cacheGet(String id) {
        TDog tDog = new TDog();
        tDog.setId(Long.valueOf(id));
        TDog dog = redisCacheController.redisGet(tDog);
        System.out.println("dog = " + dog);
        return dog;
    }

}
