package com.study.mybatis;


import com.study.mybatis.diyMybatis.pojo.Configuration;
import com.study.mybatis.diyMybatis.configure.XMLMapperBuilder;
import com.study.mybatis.diyMybatis.util.Resources;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class XMLMapperBuilderTest {

    @Test
    public void parse() throws ClassNotFoundException, DocumentException {

        InputStream inputStream = Resources.getResourceAsSteam("diy/UserMapper.xml");
        XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(new Configuration());
        xmlMapperBuilder.parse(inputStream);
    }
}
