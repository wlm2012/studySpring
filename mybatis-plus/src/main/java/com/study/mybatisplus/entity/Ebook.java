package com.study.mybatisplus.entity;

import lombok.Data;


@Data
public class Ebook{
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Long category1id;

    /**
     * 
     */
    private Long category2id;

    /**
     * 
     */
    private String cover;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private Integer docCount;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer version;

    /**
     * 
     */
    private Integer viewCount;

    /**
     * 
     */
    private Integer voteCount;

    private static final long serialVersionUID = 1L;
}