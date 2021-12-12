package com.study.thinkinspring.ioc.overview.domain;

import com.study.thinkinspring.ioc.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private City city;
    private Resource configFileLocation;

    public static User createUser() {
        return User.builder().id(1L).name("xiao").build();
    }
}
