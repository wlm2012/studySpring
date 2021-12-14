package com.study.thinkinspring.ioc.overview.domain;

import com.study.thinkinspring.ioc.enums.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.io.Resource;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private City city;
    private Resource configFileLocation;
    private City[] workCities;
    private List<City> lifeCities;

    public static User createUser() {
        return User.builder().id(1L).name("xiao").build();
    }
}
