package com.spring.jpa.DO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "t_dog")
@Getter
@Setter
@NoArgsConstructor
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int age;
    private String name;

    public Dog(Long id) {
        this.id = id;
    }
}
