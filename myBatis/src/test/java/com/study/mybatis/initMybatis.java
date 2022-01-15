package com.study.mybatis;

import com.study.mybatis.diyMybatis.DO.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class initMybatis {

    @Test
    public void test() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("init/SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> list = sqlSession.selectList("userMapper.findAll");
        list.forEach(System.out::println);

        sqlSession.close();
    }
}
