package com.study.mybatis.diyMybatis.pojo;

import com.study.mybatis.diyMybatis.util.ParameterMapping;
import lombok.AllArgsConstructor;
import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class BoundSql {

    private String sqlText;

    private List<ParameterMapping> parameterMappingList = new ArrayList<ParameterMapping>();

}
