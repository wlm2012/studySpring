package com.study.mybatis.diyMybatis.sqlsession;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface SqlSession {

    <E> List<E> selectList(String statementId, Object... param) throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException;

    <T> T selectOne(String statementId, Object... params) throws SQLException, IntrospectionException, NoSuchFieldException, InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException;

    <T> T getMappper(Class<?> mapperClass);

    void close() throws SQLException;
}
