package com.study.mybatisplus.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class GetBeanController {

    private final List<RestTemplate> restTemplates;


    @RequestMapping("/getBean")
    public void getBean() {
        restTemplates.forEach(System.out::println);
    }
}
