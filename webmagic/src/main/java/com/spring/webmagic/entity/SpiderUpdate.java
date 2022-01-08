package com.spring.webmagic.entity;


import com.spring.webmagic.entityEnum.Inquired;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "t_spider_update")
public class SpiderUpdate {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
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
