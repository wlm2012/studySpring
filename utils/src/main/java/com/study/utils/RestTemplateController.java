package com.study.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Slf4j
@RestController
public class RestTemplateController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private RestTemplate okhttpRestTemplate;

    @RequestMapping("/restTest")
    public void restTest(){
        String forObject = okhttpRestTemplate.getForObject("https://www.baidu.com", String.class);
        log.info(forObject);
    }
}
