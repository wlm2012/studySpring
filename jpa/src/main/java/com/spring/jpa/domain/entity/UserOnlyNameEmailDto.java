package com.spring.jpa.domain.entity;

import lombok.ToString;
import lombok.Value;

//@Value
@ToString
public class UserOnlyNameEmailDto {

    public UserOnlyNameEmailDto(String name, String email) {
        this.name = name;
        this.email = email;
    }




    private String name;
    private String email;
}
