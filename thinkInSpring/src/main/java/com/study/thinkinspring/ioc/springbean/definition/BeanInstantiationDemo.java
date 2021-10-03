package com.study.thinkinspring.ioc.springbean.definition;

import com.study.thinkinspring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.rowset.BaseRowSet;

public class BeanInstantiationDemo {

    public static void main(String[] args) {


        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-instantiation-context.xml");

        //构造器
        User user0 = beanFactory.getBean("user", User.class);
        System.out.println(user0);

        //静态方法
        User user = beanFactory.getBean("user-by-static-method", User.class);
        System.out.println(user);

        //实例方法
        User user1 = beanFactory.getBean("user-by-instance-method", User.class);
        System.out.println(user);


        //FactoryBean
        User user2 = beanFactory.getBean("user-by-factory-bean", User.class);
        System.out.println(user);

        System.out.println(user == user2);

    }
}
