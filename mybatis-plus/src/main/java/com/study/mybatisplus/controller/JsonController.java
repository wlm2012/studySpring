package com.study.mybatisplus.controller;

import com.study.mybatisplus.domain.entity.TJson;
import com.study.mybatisplus.mapper.TJsonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JsonController {

    private final TJsonMapper jsonMapper;

    @RequestMapping("/json")
    public void save(@RequestBody TJson json) {
        System.out.println("json = " + json);
        jsonMapper.insert(json);
    }
}
