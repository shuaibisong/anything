package com.qfedu.controller;

import com.qfedu.entity.Student;
import com.qfedu.service.StuServiceImpl;
import com.qfedu.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/StuServlet")
public class StuServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("utf-8");
       response.setContentType("text/html;utf-8");
        String paNo = request.getParameter("pageNo");
        if(paNo ==null){
            paNo="1";
        }
        PageUtil pageUtil = new PageUtil();
        StuServiceImpl stuService = new StuServiceImpl();
        int dateCount = stuService.getCount();
        int pageNo = Integer.parseInt(paNo);
        int pageSize =3;
        List<Student> students = stuService.getAll(pageNo, pageSize);
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        pageUtil.setDateCount(dateCount);
        int pageCount = pageUtil.getPageCount();
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.setAttribute("students",students);
        request.getRequestDispatcher("stu.jsp").forward(request,response);


    }
}
