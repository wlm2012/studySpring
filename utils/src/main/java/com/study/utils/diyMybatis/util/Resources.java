package com.study.utils.diyMybatis.util;

import java.io.InputStream;

public class Resources {

    public static InputStream getResourceAsSteam(String path){
        return Resources.class.getClassLoader().getResourceAsStream(path);
    }
}
