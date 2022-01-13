package com.study.mybatis.diyMybatis.sqlsession;

import com.study.mybatis.diyMybatis.configure.XMLConfigerBuilder;
import com.study.mybatis.diyMybatis.pojo.Configuration;
import org.dom4j.DocumentException;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    private Configuration configuration;
    public SqlSessionFactoryBuilder(){
        this.configuration=new Configuration();
    }

    public SqlSessionFactory build(InputStream inputStream) throws DocumentException, ClassNotFoundException {
        XMLConfigerBuilder xmlConfigerBuilder = new XMLConfigerBuilder(configuration);
        Configuration configuration = xmlConfigerBuilder.parseConfiguration(inputStream);
        return new DefaultSqlSessionFactory(configuration);
    }
}
