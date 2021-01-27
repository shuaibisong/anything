package com.qfedu.service;

import com.qfedu.entity.Student;

import java.util.List;

public interface StuServie {
    public List<Student> getAll(int pageNo , int pageSize);
    public int getCount();
}
