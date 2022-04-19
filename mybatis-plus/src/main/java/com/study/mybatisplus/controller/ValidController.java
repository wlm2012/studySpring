package com.study.mybatisplus.controller;


import com.study.mybatisplus.vo.ValidVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

/**
 * @Validated 注解可以使单独的入参检测生效 如：@NotBlank String name
 * 如果入参为对象，依旧需要注解上 @Valid
 * @NotNull：检验是否为null，可以为空字符串（“”），一般用在基本数据类型的非空校验上
 * @NotEmpty： 字符串不能为空，而且长度也必须大于0，集合也不能为空
 * @NotBlank：只能用于String类型，不能为null，而且调用trim()后（trim()用于移除字符串中的空白字符），长度必须大于0
 * @Size(min = ,max = )：用于校验字符串或者集合、map的个数，不能超出规定的最小长度和最大长度。不能用于int等非字符串和集合的字段上
 * @URL ：校验url是否是合法的url
 * @Email：检验参数是否是邮箱格式
 * @Length(min = 1,max = 100) ：校验字符串的长度是否满足要求
 * @Range(min = 1,max = 2) ：校验数字的值
 * @Max(value = 1)：小于等于数值，不能注解在字符串上
 * @Min(2) ：大于等于数值，不能注解在字符串上
 * @Digits(integer = 1,fraction = 2)：校验数字的格式　integer指定整数部分的长度 fraction指定小数部分的长度
 */
@Validated
@RestController
public class ValidController {

    @RequestMapping("/valid")
    public void valid(@RequestBody @Valid ValidVo validVo) {
        System.out.println("validVo = " + validVo);
    }

    @RequestMapping("/notblank")
    public void notBlank(@RequestBody @NotBlank ValidVo validVo) {
        System.out.println("validVo = " + validVo);
    }

    @RequestMapping("/notBlank1")
    public void notBlank1(@NotBlank String name) {
        System.out.println("name = " + name);
    }
}
