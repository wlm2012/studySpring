package com.spring.jpa.domain.entity;

import com.spring.jpa.domain.dto.DogDto;
import com.spring.jpa.domain.dto.DogUpdateDto;
import com.spring.jpa.listener.DogListener;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "t_dog")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Access(AccessType.FIELD)
@EntityListeners(DogListener.class)
public class DogEntity {
    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "com.spring.jpa.config.SnowIdGeneratorConfig")
    private String id;

    private long num;
    private int age;
    private String name;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "dog_owner_id")
    private DogOwnerEntity dogOwnerEntity;

    public DogEntity(Long num) {
        this.num = num;
    }

    public static DogEntity fromDogDto(DogDto dogDto) {
        return DogEntity.builder()
                .num(dogDto.getNum())
                .age(dogDto.getAge())
                .name(dogDto.getName())
                .build();

    }

    public void updateByDogUpdateDto(DogUpdateDto dogUpdateDto) {
        this.setNum(dogUpdateDto.getNum());
        this.setAge(dogUpdateDto.getAge());
        this.setName(dogUpdateDto.getName());
    }
}
