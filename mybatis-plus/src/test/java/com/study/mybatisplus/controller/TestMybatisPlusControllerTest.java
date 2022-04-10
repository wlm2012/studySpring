package com.study.mybatisplus.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.study.mybatisplus.entity.TUserInfo;
import com.study.mybatisplus.mapper.TUserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.lang.invoke.LambdaConversionException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestMybatisPlusControllerTest {

    @Resource
    private TUserInfoMapper userInfoMapper;


    @Test
    public void testGetUser() {
        System.out.println(userInfoMapper.selectById(1));
    }

    @Test
    void testInsert() {
        TUserInfo test = TUserInfo.builder().age(18).name("test").build();
        userInfoMapper.insert(test);
    }

    @Test
    void testWrapper(){
        QueryWrapper<TUserInfo> tUserInfoQueryWrapper = new QueryWrapper<>();
        LambdaQueryWrapper<TUserInfo> wrapper = tUserInfoQueryWrapper.lambda()
                .ge(TUserInfo::getAge, 18)
                .like(TUserInfo::getName, "e");

        wrapper.select(TUserInfo::getAge);
        List<TUserInfo> tUserInfos = userInfoMapper.selectList(wrapper);
        System.out.println("tUserInfos = " + tUserInfos);
    }


    @Test
    void testPage(){
        LambdaQueryWrapper<TUserInfo> tUserInfoLambdaQueryWrapper = new LambdaQueryWrapper<>();
        tUserInfoLambdaQueryWrapper.ge(TUserInfo::getAge,1);

        Page<TUserInfo> page = new Page<>();
        page.setSize(2).setCurrent(2);
        userInfoMapper.selectPage(page, tUserInfoLambdaQueryWrapper);
        System.out.println("tUserInfoIPage.getRecords() = " + page.getRecords());
        System.out.println("tUserInfoIPage.getCurrent() = " + page.getCurrent());
        System.out.println("page.getTotal() = " + page.getTotal());
    }




}