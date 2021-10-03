package com.study.thinkinspring.ioc.springbean.factory;

import com.study.thinkinspring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
