package com.spring.jpa.config;


import org.hibernate.cfg.AvailableSettings;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.SpringBeanContainer;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;


// 可以不用这个配置，也照样可以将jpa listener注入使用，不明白
// 如果启用这个配置，会导致配置文件中的配置无效
//@Configuration
public class JPAConfig {


//    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory1(
            DataSource dataSource, EntityManagerFactoryBuilder builder, ConfigurableListableBeanFactory beanFactory) {
        var mf = builder
                .dataSource(dataSource)
                .packages("com.spring.jpa.domain.entity")
                .build();
        mf.getJpaPropertyMap().put(AvailableSettings.BEAN_CONTAINER, new SpringBeanContainer(beanFactory));
        return mf;
    }

}
