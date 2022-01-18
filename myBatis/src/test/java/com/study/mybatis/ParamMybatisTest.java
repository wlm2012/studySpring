package com.study.mybatis;

import com.study.mybatis.DO.Order;
import com.study.mybatis.DO.User;
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
import java.util.HashMap;
import java.util.Map;

public class ParamMybatisTest {

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
    public void selectMap() {
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("menuId", 6L);
        map.put("userId", 1L);
        Order order = mapper.selectMap(map);
        System.out.println(order);
    }

    @Test
    public void selectParam() {
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = mapper.selectParam(6L, 1L);
        System.out.println(order);
    }

    @Test
    public void selectObjectParam() {
        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Order order = Order.builder().menuId(55L).build();
        User user = User.builder().name("rrr").sex("02").build();
        Order order1 = mapper.selectObjectParam(user, order);
        System.out.println(order1);
    }


}
