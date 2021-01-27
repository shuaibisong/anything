<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/15
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String contextPath = request.getContextPath();
%>

<%
    Object pagNo = request.getAttribute("pageNo");
    int pageNo = 0;
    int pageCount = 0;
    if(pagNo!=null){
       pageNo = Integer.parseInt(pagNo.toString());
    }

    Object pageCount1 = request.getAttribute("pageCount");
    if(pageCount1!=null){
        pageCount = Integer.parseInt(pageCount1.toString());
    }

%>

<table>
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
    </tr>

    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
        </tr>
    </c:forEach>

    <tr>
        <td colspan="4">
            <a href="<%=contextPath%>/StuServlet?pageNo=1">首页</a>
            <%
            if(pageNo>1){
            %>
            <a href="<%=contextPath%>/StuServlet?pageNo=${pageNo-1}">上一页</a>

            <%
                }

            if(pageNo==1){
            %>
            <a>上一页</a>
            <% }%>
        </td>

    </tr>

</table>

</body>
</html>
