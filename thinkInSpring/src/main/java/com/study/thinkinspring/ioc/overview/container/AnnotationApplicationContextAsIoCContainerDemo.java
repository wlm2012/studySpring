package com.study.thinkinspring.ioc.overview.container;

import com.study.thinkinspring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class AnnotationApplicationContextAsIoCContainerDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(AnnotationApplicationContextAsIoCContainerDemo.class);
        applicationContext.refresh();
        lookupCollectionByType(applicationContext);
        applicationContext.close();
    }

    @Bean
    public User user() {
        return User.builder().id(1L).name("xiaoma").build();
    }

    private static void lookupCollectionByType(BeanFactory beanFactory) {
        if (beanFactory instanceof ListableBeanFactory listableBeanFactory) {
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("lookupCollectionByType" + beans);
        }
    }
}
