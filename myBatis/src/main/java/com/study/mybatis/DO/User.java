package com.study.mybatis.DO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {

    private Long id;
    private String name;
    private String sex;
    private LocalDateTime createTime;
}
