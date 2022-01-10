package com.spring.jpa.DO;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "t_teacher")
public class Teacher {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "teachers")
    private Set<Student> students;
}
