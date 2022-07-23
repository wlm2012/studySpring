package com.study.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.mybatisplus.domain.entity.TUserInfo;
import com.study.mybatisplus.mapper.TUserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class TestMybatisPlusController {

    private final TUserInfoMapper tUserInfoMapper;

    @RequestMapping("/test")
    public String test() {
        QueryWrapper<TUserInfo> tUserInfoQueryWrapper = new QueryWrapper<>();
        tUserInfoQueryWrapper.lambda()
                .ge(TUserInfo::getAge,11);
        List<TUserInfo> tUserInfos = tUserInfoMapper.selectList(tUserInfoQueryWrapper);
        System.out.println("tUserInfos = " + tUserInfos);
        return "test";
    }


}
