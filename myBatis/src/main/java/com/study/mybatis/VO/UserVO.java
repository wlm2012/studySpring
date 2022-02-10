package com.study.mybatis.VO;

import com.study.mybatis.validation.Update;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Data
public class UserVO {

    @NotBlank(message = "用户名不能为空", groups = Update.class)
    private String name;


    private String mobile;

    private String idCard;

    @Valid
    private OrderVO orderVO;
}
