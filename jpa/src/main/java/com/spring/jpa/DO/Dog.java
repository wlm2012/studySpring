package com.spring.jpa.DO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "t_dog")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private long num;
    private int age;
    private String name;

    public Dog(Long num) {
        this.num = num;
    }
}
