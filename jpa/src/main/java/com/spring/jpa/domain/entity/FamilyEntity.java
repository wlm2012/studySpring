package com.spring.jpa.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_family")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FamilyEntity {
    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "com.spring.jpa.config.SnowIdGeneratorConfig")
    private String id;

    private String name;

    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ToString.Exclude
    @OneToMany(mappedBy = "familyEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SignEntity> signEntities;

}
