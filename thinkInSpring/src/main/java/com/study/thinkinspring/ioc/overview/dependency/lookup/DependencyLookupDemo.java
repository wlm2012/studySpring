package com.study.thinkinspring.ioc.overview.dependency.lookup;

import com.study.thinkinspring.ioc.overview.annotation.Super;
import com.study.thinkinspring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;


public class DependencyLookupDemo {

    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");


//        lookupInRealTime(beanFactory);
//
//        lookupInLazy(beanFactory);
//
        lookupByType(beanFactory);

        lookupCollectionByType(beanFactory);

        lookupByAnnotationType(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory listableBeanFactory) {
            Map<String, User> beans = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
            System.out.println("lookupByAnnotationType" + beans);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory listableBeanFactory) {
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookupCollectionByType" + beans);
        }
    }

    private static void lookupByType(BeanFactory beanFactory) {
        User user = beanFactory.getBean(User.class);
        System.out.println("lookupByType" + user);
    }


    private static void lookupInRealTime(BeanFactory beanFactory) {
        User user = (User) beanFactory.getBean("user");
        System.out.println("RealTime" + user);
    }

    private static void lookupInLazy(BeanFactory beanFactory) {
        ObjectFactory<User> objectFactory = (ObjectFactory<User>) beanFactory.getBean("objectFactory");
        User user = objectFactory.getObject();
        System.out.println("lazy " + user);
    }
}
