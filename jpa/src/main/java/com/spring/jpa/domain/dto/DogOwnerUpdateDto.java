package com.spring.jpa.domain.dto;

import com.spring.jpa.domain.entity.DogEntity;
import lombok.Data;

@Data
public class DogOwnerUpdateDto {

    private String id;

    private int age;

    private String name;

    private DogEntity dogEntity;
}
