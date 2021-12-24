package com.spring.webmagic.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
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


    private byte[] photo;


}
