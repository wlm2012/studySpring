package com.study.mybatis.diyMybatis.dao;

import com.study.mybatis.diyMybatis.DO.User;

import java.util.List;

public interface UserDao {

    List<User> findAll();

    User findByCondition(User user);
}
