package com.spring.jpa.domain.vo;

import lombok.ToString;

//@Value
@ToString
public class UserOnlyNameEmailVo {

    public UserOnlyNameEmailVo(String name, String email) {
        this.name = name;
        this.email = email;
    }




    private String name;
    private String email;
}
