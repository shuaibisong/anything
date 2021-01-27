package com.qfedu.dao;

import com.qfedu.entity.Student;
import com.qfedu.util.BaseDaoNew;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class StuDaoImpl implements StuDao {
    @Override
    public List<Student> select(int pageNo , int pageSize) {
        String sql ="select * from stu limit ? ,?";
        Object[] objects ={(pageNo-1)*pageSize,pageSize};
        try {
            List<Student> select = BaseDaoNew.select(sql, objects, Student.class);
            return select;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
       return  null;
    }

    @Override
    public int count() {
      String sql ="select * from stu";
        try {
            List<Student> select = BaseDaoNew.select(sql, null, Student.class);
            return select.size();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return 0;

    }
}
