package com.study.mybatis.diyMybatis.sqlsession;

import com.study.mybatis.diyMybatis.pojo.Configuration;
import com.study.mybatis.diyMybatis.pojo.MappedStatement;
import com.study.mybatis.diyMybatis.util.Executor;
import com.study.mybatis.diyMybatis.util.SimpleExecutor;

import java.beans.IntrospectionException;
import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.List;

public class DefaultSqlSession implements SqlSession {
    private Configuration configuration;
    private Executor simpleExcutor;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
        simpleExcutor = new SimpleExecutor();
    }


    @Override
    public <E> List<E> selectList(String statementId, Object... param) throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        return simpleExcutor.query(configuration, configuration.getMappedStatementMap().get(statementId), param);
    }

    @Override
    public <T> T selectOne(String statementId, Object... params) throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        List<T> objects = selectList(statementId, params);
        if (objects.size() == 1) {
            return objects.get(0);
        } else {
            throw new RuntimeException("结果过多");
        }
    }

    @Override
    public <T> T getMappper(Class<?> mapperClass) {
        Proxy.newProxyInstance(mapperClass.getClassLoader(), new Class[]{mapperClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String name = method.getName();
                System.out.println(name);
                String className = method.getDeclaringClass().getName();
                System.out.println(className);
                String key = className + "." + name;
                MappedStatement mappedStatement = configuration.getMappedStatementMap().get(key);
                Type genericReturnType = method.getGenericReturnType();
                if (genericReturnType instanceof ParameterizedType) {

                }
                return null;
            }
        });
        return null;
    }

    @Override
    public void close() throws SQLException {
        simpleExcutor.close();
    }
}
