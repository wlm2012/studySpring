package com.study.mybatisplus.controller;

import com.study.mybatisplus.domain.entity.TAddress;
import com.study.mybatisplus.mapper.TAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/address")
public class TAddressController {


    private final TAddressMapper addressMapper;

    @PostMapping("/add")
    public void add(@RequestBody TAddress address) {
        addressMapper.insert(address);
    }
}
