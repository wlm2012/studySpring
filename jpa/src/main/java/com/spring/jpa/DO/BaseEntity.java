package com.spring.jpa.DO;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.Instant;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedBy
    private Integer createUserId;
    @CreatedDate
    private LocalDateTime createTime;
    @LastModifiedBy
    private Integer lastModifiedUserId;
    @LastModifiedDate
    private Instant lastModifiedTime;
}
