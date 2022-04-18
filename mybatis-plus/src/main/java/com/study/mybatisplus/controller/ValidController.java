package com.study.mybatisplus.controller;


import com.study.mybatisplus.vo.ValidVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RestController
public class ValidController {

    @RequestMapping("/valid")
    public void valid(@RequestBody @Valid ValidVo validVo) {
        System.out.println("validVo = " + validVo);
    }

    @RequestMapping("/notblank")
    public void notbland(){

    }
}
