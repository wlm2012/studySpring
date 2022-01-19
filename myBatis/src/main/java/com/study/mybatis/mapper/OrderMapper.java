package com.study.mybatis.mapper;

import com.study.mybatis.DO.Order;
import com.study.mybatis.DO.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface OrderMapper {

    Order selectMap(Map<String, Object> map);

    Order selectParam(@Param("menuId") long menuId, @Param("userId") long userId);

    Order selectObjectParam(@Param("user") User user, @Param("order") Order order);

}
