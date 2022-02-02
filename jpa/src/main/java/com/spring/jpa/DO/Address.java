package com.spring.jpa.DO;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_address")
public class Address {

    @Id
    @Generated
    @Setter(AccessLevel.NONE)
    private Long id;

    private String city;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private UserInfo userInfo;

}
