package com.study.mybatis.diyMybatis.sqlsession;

import com.study.mybatis.diyMybatis.pojo.Configuration;
import com.study.mybatis.diyMybatis.util.Executor;
import com.study.mybatis.diyMybatis.util.SimpleExecutor;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.sql.SQLException;
import java.util.List;

public class DefaultSqlSession implements SqlSession {
    private final Configuration configuration;
    private final Executor simpleExcutor;

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
    public <T> T getMappper(Class<T> mapperClass) {
        Object o = Proxy.newProxyInstance(mapperClass.getClassLoader(), new Class[]{mapperClass}, (proxy, method, args) -> {
            String name = method.getName();
            System.out.println(name);
            String className = method.getDeclaringClass().getName();
            System.out.println(className);
            String key = className + "." + name;
            Type genericReturnType = method.getGenericReturnType();
            if (genericReturnType instanceof ParameterizedType) {
                return selectList(key, args);
            }
            return selectOne(key, args);
        });
        return (T)o;
    }

    @Override
    public void close() throws SQLException {
        simpleExcutor.close();
    }
}
