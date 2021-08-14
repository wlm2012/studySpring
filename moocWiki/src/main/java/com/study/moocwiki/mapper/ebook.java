package com.study.moocwiki.mapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ebook" , catalog = "电子书")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ebook {

    @Id
    @Column(nullable = false)
    private long id;

    @Column(length = 50, columnDefinition = "名称")
    private String name;

    @Column(columnDefinition = "分类1")
    private long category1Id;

    @Column(columnDefinition = "分类2")
    private long category2Id;

    @Column(length = 200, columnDefinition = "描述")
    private String description;

    @Column(length = 200, columnDefinition = "封面")
    private String cover;

    @Column(columnDefinition = "文档数")
    private int docCount;

    @Column(columnDefinition = "阅读数")
    private int viewCount;

    @Column(columnDefinition = "点赞数")
    private int voteCount;

}
