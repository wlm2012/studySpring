package com.study.moocwiki.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ebook")
@org.hibernate.annotations.Table(appliesTo = "ebook", comment = "电子书")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ebook {

    @Id
    @Column(nullable = false)
    private long id;

    @Column(length = 50)
    private String name;

    private long category1Id;

    private long category2Id;

    @Column(length = 200)
    private String description;

    @Column(length = 200)
    private String cover;

    private int docCount;

    private int viewCount;

    private int voteCount;

}
