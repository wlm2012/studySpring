package com.spring.jpa.DO;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "t_dog")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Dog {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BATCH_SEQ")
    @SequenceGenerator(name = "BATCH_SEQ", sequenceName = "BATCH_SEQ", allocationSize = 500)
    private Long id;

    private long num;
    private int age;
    private String name;

    public Dog(Long num) {
        this.num = num;
    }
}
