package com.spring.jpa.domain.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "t_sign")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignEntity {
    @Id
    @GeneratedValue(generator = "snowflakeId")
    @GenericGenerator(name = "snowflakeId", strategy = "com.spring.jpa.config.SnowIdGeneratorConfig")
    private String id;

    @ToString.Exclude
    @ManyToOne
    @JoinColumn(name = "family_id")
    private FamilyEntity familyEntity;

    @ToString.Exclude
    @JoinColumn(name = "doctor_id")
    @ManyToOne
    private DoctorEntity doctorEntity;

    private LocalDate beginDate;
}
