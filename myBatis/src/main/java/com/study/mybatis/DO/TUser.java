package com.study.mybatis.DO;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
public class TUser  {
    /**
     * 
     */
    private Long id;

    /**
     * 
     */
    private Date createTime;

    /**
     * 
     */
    private Integer createUserId;

    /**
     * 
     */
    private Date lastModifiedTime;

    /**
     * 
     */
    private Integer lastModifiedUserId;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private Date birthday;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Date registeredTime;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private String state;

    /**
     * 
     */
    private Integer version;


}