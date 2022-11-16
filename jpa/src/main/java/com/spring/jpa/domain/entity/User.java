package com.spring.jpa.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "com.spring.jpa.config.SnowIdGeneratorConfig")
    private String id;

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

    @ToString.Exclude
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH}, orphanRemoval = true)
    private Set<FamilyEntity> familyEntities;

}
