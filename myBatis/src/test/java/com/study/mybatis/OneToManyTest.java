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

public class OneToManyTest {

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
    public void test(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Order order = mapper.selectLazy(2);
        System.out.println(order.getMenuId());
        System.out.println("延迟加载");
        System.out.println(order.getUser());
    }
}
