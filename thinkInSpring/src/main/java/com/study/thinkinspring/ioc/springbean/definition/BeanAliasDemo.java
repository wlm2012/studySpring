package com.study.thinkinspring.ioc.springbean.definition;

import com.study.thinkinspring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAliasDemo {

    public static void main(String[] args) {

        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        User xiaomageUser = beanFactory.getBean("xiaomage-user", User.class);
        User user = beanFactory.getBean("user", User.class);
        System.out.println(user == xiaomageUser);

    }
}
