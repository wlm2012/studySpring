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
@Table(name = "ebook")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ebook {

    @Id
    private long id;
    @Column(length = 50)
    private String name;

}
