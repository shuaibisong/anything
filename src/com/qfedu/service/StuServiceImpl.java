package com.qfedu.service;

import com.qfedu.dao.StuDao;
import com.qfedu.dao.StuDaoImpl;
import com.qfedu.entity.Student;

import java.util.List;

public class StuServiceImpl implements StuServie {
    @Override
    public List<Student> getAll(int pageNo, int pageSize) {
        StuDao stuDao = new StuDaoImpl();
        List<Student> list = stuDao.select(pageNo, pageSize);
        return list;

    }

    @Override
    public int getCount() {
        StuDaoImpl stuDao = new StuDaoImpl();
        int count = stuDao.count();
        return count;
    }
}
