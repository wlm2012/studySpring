package com.study.mybatis.mapper;

import com.study.mybatis.DO.Order;
import com.study.mybatis.DO.User;
import org.apache.ibatis.annotations.Select;

import java.util.Collection;
import java.util.List;


public interface UserMapper {

    List<Order> findByOrderId(Collection<Integer> integers);

    List<User> findById(Collection<Integer> integers);

    @Select("")
    List<Order> findByOrderIdannotation(Collection<Integer> integers);
}
