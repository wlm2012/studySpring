package com.study.mybatis.diyMybatis.util;

import java.io.InputStream;

public class Resources {

    public static InputStream getResourceAsSteam(String path){
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
