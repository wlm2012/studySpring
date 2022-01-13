package com.study.mybatis.diyMybatis.util;

import com.study.mybatis.diyMybatis.pojo.Configuration;
import com.study.mybatis.diyMybatis.pojo.MappedStatement;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface Executor {
    <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object[] param) throws SQLException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, IntrospectionException;

    void close() throws SQLException;
}
