package com.qfedu.dao;

import com.qfedu.entity.Student;

import java.util.List;

public interface StuDao {
    public List<Student> select(int pageNo , int pageSize);
    public int count();
}
