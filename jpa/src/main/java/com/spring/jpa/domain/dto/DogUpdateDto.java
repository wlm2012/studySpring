package com.spring.jpa.domain.dto;

import lombok.Data;

@Data
public class DogUpdateDto {

    private String id;

    private long num;
    private int age;
    private String name;
}
