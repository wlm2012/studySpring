package com.study.utils.diyMybatis.configure;

import com.study.utils.diyMybatis.util.Resources;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class XMLConfigerBuilder {

    private Configuration configuration;

    public XMLConfigerBuilder(Configuration configuration) {
        this.configuration = configuration;
    }

    public Configuration parseConfiguration(InputStream inputStream) throws DocumentException, ClassNotFoundException {
        Document document = new SAXReader().read(inputStream);
        Element rootElement = document.getRootElement();
        List<Node> propertyElements = rootElement.selectNodes("//property");
        Properties properties = new Properties();

        for (Node node : propertyElements) {
            if (node instanceof Element propertyElement) {
                String name = propertyElement.attributeValue("name");
                String value = propertyElement.attributeValue("value");
                properties.setProperty(name, value);
            }
        }
        HikariConfig hikariConfig = new HikariConfig(properties);
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        configuration.setDataSource(hikariDataSource);
        List<Node> mapperElements = rootElement.selectNodes("//mapper");
        XMLMapperBuilder xmlMapperBuilder = new XMLMapperBuilder(configuration);
        for (Node node : mapperElements) {
            if (node instanceof Element mapperElement) {
                String mapperPath = mapperElement.attributeValue("resource");
                InputStream resourceAsSteam = Resources.getResourceAsSteam(mapperPath);
                xmlMapperBuilder.parse(resourceAsSteam);
            }
        }
        return configuration;
    }
}
