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
                @Index(columnList = "chineseName")
        })
public class AVstar {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String chineseName;
    private int score;
    private byte[] photo;


}
