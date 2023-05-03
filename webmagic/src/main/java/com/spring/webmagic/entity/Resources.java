package com.spring.webmagic.entity;

import com.spring.webmagic.entityEnum.ResourcesEnum;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_resources")
public class Resources {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private Long id;

    private String name;

    private String path;

    private ResourcesEnum type;

    @ManyToMany(mappedBy = "resourcesSet")
    private Set<AVstar> AVstarSet = new HashSet<>();

    private boolean exist;
}
