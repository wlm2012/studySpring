package com.study.utils.diyMybatis.configure;

import lombok.Data;

@Data
public class MappedStatement {

    private String id;

    private String sql;

    private Class<?> paramterType;

    private Class<?> resultType;
}
