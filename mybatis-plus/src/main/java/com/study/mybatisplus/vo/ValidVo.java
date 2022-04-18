package com.study.mybatisplus.vo;

import lombok.Data;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
public class ValidVo {

    @Min(0)
    private Long id;
    @NotBlank
    private String name;

}
