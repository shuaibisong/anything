package com.qfedu.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoNew {

    public static <T> List<T> select(String sql, Object[] paras , Class<T> cls) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if(sql == null) {
            throw new NullPointerException();
        }
        Connection connection = PoolJdbc.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
        if(paras!=null && parameterCount==paras.length){
            for (int i = 1; i <=parameterCount ; i++) {
                preparedStatement.setObject(i,paras[i-1]);
            }

        }
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<T> list = new ArrayList<>();
        while (resultSet.next()){
            T t = cls.getConstructor(null).newInstance(null);
            for (int i = 1; i <= columnCount ; i++) {
                String columnName = metaData.getColumnName(i);
                Object values = resultSet.getObject(columnName);
                BeanUtils.setProperty(t,columnName,values);
            }
            list.add(t);
        }

         return list;
    }

}
