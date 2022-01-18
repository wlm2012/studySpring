package com.study.mybatis.mapper;

import com.study.mybatis.DO.Order;
import com.study.mybatis.DO.User;
import org.apache.ibatis.annotations.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public interface UserMapper {

    List<Order> findByOrderId(Collection<Integer> integers);

    List<User> findById(Collection<Integer> integers);

    @Select("select id,create_time, name ,sex from t_user where id =#{id}")
    User getOne(Integer id);

    @Select("select * from t_order where id = #{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "user", column = "user_id", javaType = User.class,
                    one = @One(select = "com.study.mybatis.mapper.UserMapper.getOne"))
    })
    Order findByOrderIdannotation(Long id);


    @Select("select id,create_time, name ,sex from t_user")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orders", column = "id",
//                    一对多，多对多，需要javaType = List.class
                    javaType = List.class,
                    many = @Many(select = "com.study.mybatis.mapper.UserMapper.getOrder"))
    })
    List<User> findAll();

    @Select("select * from t_order where user_id =#{id}")
    List<Order> getOrder(Integer id);

    int insert(Order order);

    int insert2(Order order);


}
