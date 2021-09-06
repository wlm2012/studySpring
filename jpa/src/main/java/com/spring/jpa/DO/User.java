package com.spring.jpa.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "t_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")
        },
        indexes = {
                @Index(columnList = "name,age")
        })
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    @Column(length = 2)
    private String state;
    @Column(length = 2)
    private String sex;
    private String email;
}
