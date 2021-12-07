package com.spring.webmagic.entity;


import com.spring.webmagic.entityEnum.Inquired;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "t_spider_update")
public class SpiderUpdate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @Lob
    private String content;

    @Lob
    private String beforeContent;

    private String url;

    private boolean updated = false;

    private Inquired inquired;


}
