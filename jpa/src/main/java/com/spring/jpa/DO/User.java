package com.spring.jpa.DO;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "t_user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "id")
        },
        indexes = {
                @Index(columnList = "name,age")
        })
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

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

    @Version
    private Integer version;
    private LocalDate birthday;
    private LocalDateTime registeredTime;


}
