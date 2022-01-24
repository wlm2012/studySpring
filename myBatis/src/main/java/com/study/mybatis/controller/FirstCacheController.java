package com.study.mybatis.controller;

import com.study.mybatis.DO.TOrder;
import com.study.mybatis.mapper.TOrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstCacheController {

    private final TOrderMapper tOrderMapper;

    @Autowired
    public FirstCacheController(TOrderMapper tOrderMapper) {
        this.tOrderMapper = tOrderMapper;
    }

    @RequestMapping("/first")
    public TOrder first(Long id) {
        return tOrderMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/second")
    public TOrder second(Long id) {
        return tOrderMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/third")
    public TOrder third(Long id) {
        TOrder tOrder = tOrderMapper.selectByPrimaryKey(id);
        TOrder tOrder1 = tOrderMapper.selectByPrimaryKey(id);
        System.out.println(tOrder == tOrder1);
        return tOrder;
    }

    @Transactional
    @RequestMapping("/fourth")
    public TOrder fourth(Long id) {
        TOrder tOrder = tOrderMapper.selectByPrimaryKey(id);
        TOrder tOrder1 = tOrderMapper.selectByPrimaryKey(id);
        System.out.println(tOrder == tOrder1);
        return tOrder;
    }

}
