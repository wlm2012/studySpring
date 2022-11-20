package com.spring.jpa.domain.entity;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "t_book")
public class Book {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    private double price;

    @ToString.Exclude
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors;

}
