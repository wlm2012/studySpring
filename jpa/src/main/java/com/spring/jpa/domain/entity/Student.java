package com.spring.jpa.domain.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "t_student")
public class Student {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(length = 127)
    private String name;

    @ManyToMany
    private Set<Teacher> teachers;

}
