package com.study.thinkinspring.ioc.springbean.factory;

import com.study.thinkinspring.ioc.overview.domain.User;

public interface UserFactory {

    default User createUser() {
        return User.builder().id(2L).name("xi").build();
    }

    void initUserFactory();

    void doDestroy();
}
