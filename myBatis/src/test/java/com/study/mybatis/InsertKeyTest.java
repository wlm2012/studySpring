package com.study.mybatis;

import com.study.mybatis.DO.Order;
import com.study.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class InsertKeyTest {

    private static SqlSession sqlSession;

    @BeforeAll
    public static void openSqlSession() throws IOException {
        try (InputStream inputStream = Resources.getResourceAsStream("init/SqlMapConfig.xml")) {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
        }

    }

    @AfterAll
    public static void close() {
        sqlSession.close();
    }


    @Test
    public void insert() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Order order = Order.builder().menuId(99L).userId(9L).build();
        long insert = mapper.insert(order);
        System.out.println(insert);
        System.out.println(order.getId());
        sqlSession.commit();
    }

    @Test
    public void insert2() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Order order = Order.builder().menuId(9L).userId(9L).build();
        long insert = mapper.insert2(order);
        System.out.println(insert);
        System.out.println(order.getId());
        sqlSession.commit();
    }


    @Test
    public void insert3(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Order order = Order.builder().menuId(99L).userId(9L).build();
        long insert = mapper.insert3(order);
        System.out.println(insert);
        System.out.println(order.getId());
        sqlSession.commit();
    }

    @Test
    public void insert4(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Order order = Order.builder().menuId(99L).userId(9L).build();
        long insert = mapper.insert4(order);
        System.out.println(insert);
        System.out.println(order.getId());
        sqlSession.commit();
    }
}
