package com.spring.webmagic.entity;

import com.spring.webmagic.entityEnum.ResourcesEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "t_resources")
public class Resources {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    private String path;

    private ResourcesEnum type;

    private Long avId;

    private boolean exist;
}
