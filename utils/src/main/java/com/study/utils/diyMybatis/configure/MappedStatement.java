package com.study.utils.diyMybatis.configure;

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
