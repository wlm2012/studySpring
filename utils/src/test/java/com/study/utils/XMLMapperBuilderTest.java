package com.study.utils;

import com.study.utils.diyMybatis.configure.Configuration;
import com.study.utils.diyMybatis.util.Resources;
import com.study.utils.diyMybatis.configure.XMLMapperBuilder;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

public class XMLMapperBuilderTest {

    @Test
    public void parse() throws DocumentException, ClassNotFoundException {

        InputStream inputStream = Resources.getResourceAsSteam("UserMapper.xml");
        XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(new Configuration());
        xmlMapperBuilder.parse(inputStream);
    }
}
