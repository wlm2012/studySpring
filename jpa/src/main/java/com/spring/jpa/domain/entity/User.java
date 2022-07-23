package com.spring.jpa.domain.entity;

import lombok.*;

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

    //如果数据库中为null，则为空指针错误
    @Version
    private Integer version = 0;
    private LocalDate birthday;
    private LocalDateTime registeredTime;


}
