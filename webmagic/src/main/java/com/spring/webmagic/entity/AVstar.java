package com.spring.webmagic.entity;

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
    @GeneratedValue
    private Long id;

    private String name;
    private String chineseName;
    private int score;
    private String description;
    private byte[] photo;


}
