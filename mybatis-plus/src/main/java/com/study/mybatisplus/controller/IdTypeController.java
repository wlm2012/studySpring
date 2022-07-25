package com.study.mybatisplus.controller;

import com.study.mybatisplus.domain.entity.TAddress;
import com.study.mybatisplus.mapper.TAddressMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class IdTypeController {

    private final TAddressMapper addressMapper;

    @PostMapping("/addAddress")
    public void addAddress(@RequestBody TAddress address) {
        addressMapper.insert(address);
    }
}
