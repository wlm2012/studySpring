package com.study.mybatis;

import com.study.mybatis.diyMybatis.DO.User;
import com.study.mybatis.diyMybatis.dao.UserDao;
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

public class DiyMybatisTest {

    @Test
    public void test() throws DocumentException, ClassNotFoundException, SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("diy/sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> users = sqlSession.selectList("com.study.mybatis.diyMybatis.dao.UserDao.findAll");
        users.forEach(System.out::println);

        System.out.println("--------------------");
        User user = new User();
        user.setId(1L);
        user.setName("qqq");
        User user1 = sqlSession.selectOne("com.study.mybatis.diyMybatis.dao.UserDao.findByCondition", user);
        System.out.println(user1);

        sqlSession.close();
    }

    @Test
    public void test2() throws DocumentException, ClassNotFoundException {
        InputStream resourceAsSteam = Resources.getResourceAsSteam("diy/sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsSteam);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserDao mappper = sqlSession.getMappper(UserDao.class);
        List<User> all = mappper.findAll();
        all.forEach(System.out::println);
        User user = new User();
        user.setId(1L);
        user.setName("qqq");
        User byCondition = mappper.findByCondition(user);
        System.out.println(byCondition);

    }



}
