package com.study.mybatis.controller;

import com.github.pagehelper.PageHelper;
import com.study.mybatis.DO.TDog;
import com.study.mybatis.mapper.TDogMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PageHelperController {

    private final TDogMapper tDogMapper;

    public PageHelperController(TDogMapper tDogMapper) {
        this.tDogMapper = tDogMapper;
    }

    @RequestMapping("/pageHelper")
    public void pageHelper() {
        PageHelper.startPage(1, 20);
        List<TDog> tDogs = tDogMapper.selectAll();
        System.out.println("tDogs.size() = " + tDogs.size());
        tDogs.forEach(System.out::println);
    }
}
