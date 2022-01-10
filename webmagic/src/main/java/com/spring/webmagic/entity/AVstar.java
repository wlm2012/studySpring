package com.spring.webmagic.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_av_star",
        indexes = {
                @Index(columnList = "name"),
                @Index(columnList = "chineseName"),
                @Index(columnList = "score")
        })
public class AVstar {

    @Id
    @Setter(AccessLevel.NONE)
    @GeneratedValue
    private Long id;

    private String name;
    private String chineseName;
    private int score;
    private String description;
    private boolean confirm = false;
    private boolean exist = false;

    @ManyToMany
    @JoinTable(
            name = "t_av_star_resources",
            joinColumns = @JoinColumn(name = "av_star_id"),
            inverseJoinColumns = @JoinColumn(name = "resources_id"))
    private Set<Resources> resourcesSet;


    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] photo;




}
