package com.study.mybatis.diyMybatis.configure;

import com.study.mybatis.diyMybatis.pojo.Configuration;
import com.study.mybatis.diyMybatis.pojo.MappedStatement;
import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

public class XMLMapperBuilder {

    private Configuration configuration;

    public XMLMapperBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public void parse(InputStream inputStream) throws DocumentException, ClassNotFoundException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        String namespace = rootElement.attributeValue("namespace");
        List<Node> select = rootElement.selectNodes("//select");
        for (Node node : select) {
            if (node instanceof Element element) {
                String id = element.attributeValue("id");
                String paramterType = element.attributeValue("paramterType");
                String resultType = element.attributeValue("resultType");
                Class<?> paramterTypeClass = getClassType(paramterType);
                Class<?> resultTypeClass = getClassType(resultType);
                String key = namespace + "." + id;
                String textTrim = element.getTextTrim();

                MappedStatement mappedStatement = MappedStatement.builder()
                        .id(id)
                        .paramterType(paramterTypeClass)
                        .resultType(resultTypeClass)
                        .sql(textTrim).build();

                configuration.getMappedStatementMap().put(key, mappedStatement);
            }
        }

    }

    private Class<?> getClassType(String paramterType) throws ClassNotFoundException {
        return Class.forName(paramterType);
    }
}
