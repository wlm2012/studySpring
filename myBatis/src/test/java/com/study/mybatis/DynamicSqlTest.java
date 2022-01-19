package com.study.mybatis;

import com.study.mybatis.DO.Order;
import com.study.mybatis.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;

public class DynamicSqlTest {

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
    public void selectChoose() {
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order build = Order.builder().menuId(7L).build();
        Order order = mapper.selectChoose(build);
        System.out.println(order);
    }


    @Test
    public void updateSet() {
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        mapper.updateSet(Order.builder().id(1L).userId(996L).build());
        sqlSession.commit();
    }
}
