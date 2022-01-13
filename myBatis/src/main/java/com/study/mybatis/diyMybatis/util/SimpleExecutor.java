package com.study.mybatis.diyMybatis.util;

import com.study.mybatis.diyMybatis.pojo.BoundSql;
import com.study.mybatis.diyMybatis.pojo.Configuration;
import com.study.mybatis.diyMybatis.pojo.MappedStatement;
import org.apache.ibatis.parsing.GenericTokenParser;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SimpleExecutor implements Executor {
    private Connection connection = null;


    @Override
    public <E> List<E> query(Configuration configuration, MappedStatement mappedStatement, Object[] param) throws SQLException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, IntrospectionException {
        BoundSql boundsql = getBoundSql(mappedStatement.getSql());
        connection = configuration.getDataSource().getConnection();
        String finalSql = boundsql.getSqlText();
        PreparedStatement preparedStatement = connection.prepareStatement(finalSql);

        Class<?> paramterType = mappedStatement.getParamterType();
        List<ParameterMapping> parameterMappingList = boundsql.getParameterMappingList();
        for (int i = 0; i < parameterMappingList.size(); i++) {
            ParameterMapping parameterMapping = parameterMappingList.get(i);
            String name = parameterMapping.getContent();

            //  reflect
            Field declaredField = paramterType.getDeclaredField(name);
            declaredField.setAccessible(true);
            Object o = declaredField.get(param[0]);

            preparedStatement.setObject(i + 1, o);
        }

        ResultSet resultSet = preparedStatement.executeQuery();
        Class<?> resultType = mappedStatement.getResultType();
        List<E> results = new ArrayList<E>();

        while (resultSet.next()) {
            ResultSetMetaData metaData = resultSet.getMetaData();
            E o = (E) resultType.getConstructor().newInstance();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Object value = resultSet.getObject(columnName);

                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(columnName, resultType);
                Method writeMethod = propertyDescriptor.getWriteMethod();
                writeMethod.invoke(o, value);
            }
            results.add(o);
        }
        return results;
    }

    @Override
    public void close() throws SQLException {
        connection.close();
    }

    private BoundSql getBoundSql(String sql) {

        ParameterMappingTokenHandler parameterMappingTokenHandler = new ParameterMappingTokenHandler();
        GenericTokenParser genericTokenParser = new GenericTokenParser("# {", "}", parameterMappingTokenHandler);
        String parse = genericTokenParser.parse(sql);
        List<ParameterMapping> parameterMappings = parameterMappingTokenHandler.getParameterMappings();
        return new BoundSql(parse, parameterMappings);
    }
}
