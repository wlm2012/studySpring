package com.spring.jpa.DO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
    private LocalDate birthday;
    private LocalDateTime registeredTime;
}
