package com.spring.jpa.domain.entity;


import com.spring.jpa.domain.dto.DogOwnerAddDto;
import com.spring.jpa.domain.dto.DogOwnerUpdateDto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_dog_owner")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
public class DogOwnerEntity {

    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "com.spring.jpa.config.SnowIdGeneratorConfig")
    private String id;


    private int age;

    private String name;

    @OneToMany(mappedBy = "dogOwnerEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private List<DogEntity> dogEntityList = new ArrayList<>();


    public static DogOwnerEntity fromDogOwnerDto(DogOwnerAddDto dogOwnerAddDto) {
        return DogOwnerEntity.builder()
                .age(dogOwnerAddDto.getAge())
                .name(dogOwnerAddDto.getName())
                .build();

    }

    public void updateByDogOwnerUpdateDto(DogOwnerUpdateDto dogOwnerUpdateDto) {
        this.setAge(dogOwnerUpdateDto.getAge());
        this.setName(dogOwnerUpdateDto.getName());
        this.getDogEntityList().add(dogOwnerUpdateDto.getDogEntity());
        dogOwnerUpdateDto.getDogEntity().setDogOwnerEntity(this);
    }
}
