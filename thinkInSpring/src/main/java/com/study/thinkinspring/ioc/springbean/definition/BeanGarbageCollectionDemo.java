package com.study.thinkinspring.ioc.springbean.definition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanGarbageCollectionDemo {

    public static void main(String[] args) throws InterruptedException {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(BeanInitializationDemo.class);
        applicationContext.refresh();
        applicationContext.close();
        Thread.sleep(5000);
        System.gc();
        Thread.sleep(5000);
    }
}
