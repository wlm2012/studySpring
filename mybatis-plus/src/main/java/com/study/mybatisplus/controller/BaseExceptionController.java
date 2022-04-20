package com.study.mybatisplus.controller;

import com.study.mybatisplus.entity.TAddress;
import com.study.mybatisplus.exception.BaseException;
import com.study.mybatisplus.mapper.TAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class BaseExceptionController {

    private final TAddressMapper tAddressMapper;

    @RequestMapping("/exception")
    @Transactional(rollbackFor = Exception.class)
    public void exception(@RequestBody TAddress tAddress) {
        int insert = tAddressMapper.insert(tAddress);
        System.out.println(insert);
        if (1 == insert) {
            throw new BaseException(500, "回滚");
        }
    }
}
