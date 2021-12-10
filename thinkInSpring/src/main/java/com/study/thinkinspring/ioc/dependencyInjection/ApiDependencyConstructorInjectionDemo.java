package com.study.thinkinspring.ioc.dependencyInjection;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApiDependencyConstructorInjectionDemo {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        BeanDefinition userHolderBeanDefinition = createUserHolderBeanDefinition();
        applicationContext.registerBeanDefinition("userHolder", userHolderBeanDefinition);

        XmlBeanDefinitionReader reader=new XmlBeanDefinitionReader(applicationContext);
        String xmlResourcePath = "classpath:/META-INF/dependency-lookup-context.xml";
        reader.loadBeanDefinitions(xmlResourcePath);

        applicationContext.refresh();
        UserHolder userHolder = applicationContext.getBean(UserHolder.class);
        System.out.println(userHolder);
        applicationContext.close();


    }

    public static BeanDefinition createUserHolderBeanDefinition() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(UserHolder.class);
        builder.addConstructorArgReference("superUser");
        return builder.getBeanDefinition();
    }
}
