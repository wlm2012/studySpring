package com.study.mybatis;

import com.study.mybatis.DO.Order;
import com.study.mybatis.diyMybatis.DO.User;
import com.study.mybatis.diyMybatis.dao.UserDao;
import com.study.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class initMybatis {

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
    public void test() {
        List<User> list = sqlSession.selectList("userMapper.findAll");
        list.forEach(System.out::println);
    }


    @Test
    public void test1() {

        User insert = User.builder().id(9L).name("rrr").build();
        sqlSession.insert("userMapper.add", insert);
        sqlSession.commit();


        User delete = User.builder().id(2L).build();
        sqlSession.delete("userMapper.delete", delete);
        sqlSession.commit();


        User update = User.builder().id(1L).name("wlm").build();
        sqlSession.update("userMapper.update", update);
        sqlSession.commit();
    }

    @Test
    public void test2() {

        UserDao mapper = sqlSession.getMapper(UserDao.class);

        User build = User.builder().name("wlm").build();
        User byCondition = mapper.findByCondition(build);
        System.out.println(byCondition);
    }

    @Test
    public void test3() {
        UserDao mapper = sqlSession.getMapper(UserDao.class);

        List<User> users = mapper.findByName(List.of("rrr", "fff"));
        users.forEach(System.out::println);
    }

    @Test
    public void test4() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<Order> orders = mapper.findByOrderId(List.of(2, 3));
        orders.forEach(System.out::println);
    }

    @Test
    public void test5() {
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<com.study.mybatis.DO.User> users = mapper.findById(List.of(1, 9, 19));
        users.forEach(System.out::println);
    }
}
