package com.study.thinkinspring.ioc.springbean.definition;

import com.study.thinkinspring.ioc.springbean.factory.DefaultUserFactory;
import com.study.thinkinspring.ioc.springbean.factory.UserFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class BeanInitializationDemo {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();
        System.out.println("Spring 应用上下文已启动...");
        UserFactory userFactory = applicationContext.getBean(UserFactory.class);
        System.out.println("Spring 应用上下文准备关闭...");
        applicationContext.close();
        System.out.println("Spring 应用上下文已关闭...");
    }

    @Lazy
    @Bean(initMethod = "initUserFactory", destroyMethod = "doDestroy")
    public UserFactory userFactory() {
        return new DefaultUserFactory();
    }

}
