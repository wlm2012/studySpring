package com.study.mybatisplus.vo;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ValidVo {

    @Min(10)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String num;

}
