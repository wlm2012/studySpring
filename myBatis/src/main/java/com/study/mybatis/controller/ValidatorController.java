package com.study.mybatis.controller;

import com.study.mybatis.VO.UserVO;
import com.study.mybatis.validation.Update;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ValidatorController {

    @RequestMapping("/userVO")
    public UserVO userVO(@Validated({Update.class}) @RequestBody UserVO userVO, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("result.getAllErrors() = " + result.getAllErrors());
        }
        System.out.println("userVO = " + userVO);
        return userVO;
    }
}
