package com.study.thinkinspring.ioc.overview.container;

import com.study.thinkinspring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

public class BeanFactoryAsIoCContainerDemo {

    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        String location = "classpath:/META-INF/dependency-lookup-context.xml";
        int beanDefinitions = reader.loadBeanDefinitions(location);
        System.out.println(beanDefinitions);
        lookupCollectionByType(beanFactory);

    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory listableBeanFactory) {
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookupCollectionByType" + beans);
        }
    }
}
