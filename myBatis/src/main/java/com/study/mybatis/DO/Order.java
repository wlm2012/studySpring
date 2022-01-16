package com.study.mybatis.DO;

import lombok.Data;

@Data
public class Order {

    private Long id;
    private Long menuId;
    private Long userId;
    private User user;
}
