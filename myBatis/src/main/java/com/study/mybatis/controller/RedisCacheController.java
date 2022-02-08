package com.study.mybatis.controller;


import com.study.mybatis.DO.TDog;
import com.study.mybatis.mapper.TDogMapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class RedisCacheController {

    @Resource
    private TDogMapper tDogMapper;

    @RequestMapping("/redisGet")
    @Cacheable(value = "TDog", key = "#tDog.id", unless = "#result == null")
    public TDog redisGet(@RequestBody TDog tDog) {
        Long id = tDog.getId();
        return tDogMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/redisUpdate")
    @CachePut(value = "TDog", key = "#tDog.id", unless = "#result == null")
    public TDog redisUpdate(@RequestBody TDog tDog) {
        tDogMapper.updateByPrimaryKey(tDog);
        return tDog;
    }

    @RequestMapping("/redisDelete")
    @CacheEvict(value = "TDog", key = "#tDog.id")
    public void redisDelete(@RequestBody TDog tDog) {

    }

    @RequestMapping("/redisListGet")
    @Cacheable(value = "TDogList", key = "#tDog", unless = "#result == null")
    public List<TDog> redisListGet(@RequestBody TDog tDog) {
        return tDogMapper.selective(tDog);
    }
}
