package com.spring.jpa.config;


import org.hibernate.cfg.AvailableSettings;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.SpringBeanContainer;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

@Configuration
public class HibernateConfig {


    public HibernateConfig(LocalContainerEntityManagerFactoryBean entityManagerFactoryBuilder, ConfigurableListableBeanFactory factory){
        entityManagerFactoryBuilder.getJpaPropertyMap().put(AvailableSettings.BEAN_CONTAINER, new SpringBeanContainer(factory));
    }
}
