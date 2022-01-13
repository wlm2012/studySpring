package com.study.mybatis;

import com.study.mybatis.diyMybatis.DO.User;
import com.study.mybatis.diyMybatis.sqlsession.SqlSession;
import com.study.mybatis.diyMybatis.sqlsession.SqlSessionFactory;
import com.study.mybatis.diyMybatis.sqlsession.SqlSessionFactoryBuilder;
import com.study.mybatis.diyMybatis.util.Resources;
import org.dom4j.DocumentException;
import org.junit.jupiter.api.Test;

import java.beans.IntrospectionException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class DiyMybatis {

    @Test
    public void test() throws DocumentException, ClassNotFoundException, SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users = sqlSession.selectList("User.selectList");
        users.forEach(System.out::println);

        System.out.println("--------------------");
        User user = new User();
        user.setId(1L);
        user.setName("qqq");
        List<Object> list = sqlSession.selectOne("User.selectList", user);
        list.forEach(System.out::println);

        sqlSession.close();
    }



}
