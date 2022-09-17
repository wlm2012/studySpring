package com.spring.jpa.domain.dto;

import com.spring.jpa.domain.entity.DogEntity;
import lombok.Data;

import java.util.List;

@Data
public class DogsDto {

    private String dogOwnerId;

    private List<DogDto> dogDtoList;
}
