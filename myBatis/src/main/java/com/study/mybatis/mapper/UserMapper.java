package com.study.mybatis.mapper;

import com.study.mybatis.DO.Order;

import java.util.Collection;
import java.util.List;

public interface UserMapper {

    List<Order> findByOrderId(Collection<Integer> integers);
}
