package com.study.thinkinspring.ioc.overview.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;

    public static User createUser() {
        return User.builder().id(1L).name("xiao").build();
    }
}
