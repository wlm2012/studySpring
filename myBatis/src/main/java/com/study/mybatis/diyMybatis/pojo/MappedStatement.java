package com.study.mybatis.diyMybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MappedStatement {

    private String id;

    private String sql;

    private Class<?> paramterType;

    private Class<?> resultType;
}
