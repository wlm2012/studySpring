package com.study.mybatis.diyMybatis.util;

import org.apache.ibatis.parsing.TokenHandler;

import java.util.ArrayList;
import java.util.List;


public class ParameterMappingTokenHandler   implements TokenHandler {


    private final List<ParameterMapping> parameterMappings = new ArrayList<>();


    public ParameterMappingTokenHandler(){
    }



    public List<ParameterMapping> getParameterMappings() {
        return parameterMappings;
    }

    @Override
    public String handleToken(String content) {
        parameterMappings.add(buildParameterMapping(content));
        return "?";
    }

    private ParameterMapping buildParameterMapping(String content) {
        return new ParameterMapping(content);
    }

}
