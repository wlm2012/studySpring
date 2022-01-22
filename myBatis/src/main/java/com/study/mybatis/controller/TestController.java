package com.study.mybatis.controller;

import com.study.mybatis.DO.TAuthor;
import com.study.mybatis.mapper.TAuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private final TAuthorMapper tAuthorMapper;

    @Autowired
    public TestController(TAuthorMapper tAuthorMapper) {
        this.tAuthorMapper = tAuthorMapper;
    }

    @RequestMapping("/tAuthorMapper/{id}")
    public void test(@PathVariable Long id) {
        TAuthor tAuthor = tAuthorMapper.selectByPrimaryKey(id);
        System.out.println(tAuthor);
    }


}
