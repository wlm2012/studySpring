package com.spring.jpa.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Getter
@Setter
@ToString(exclude = "addresses")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_user_info")
public class UserInfo {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    private Integer age;

    @OneToMany(mappedBy = "userInfo", fetch = FetchType.LAZY)
    private Set<Address> addresses;
}
