<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/11/14
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <h1>用户列表</h1>
    <a href="user/add_user.jsp">添加用户</a>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>password</th>
            <th>修改</th>
            <th>删除</th>
        </tr>
        <c:forEach items="${user}" var="user" varStatus="s">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.password}</td>
                <td><a href="mod?id=${user.id}">修改</a></td>
                <td><a href="del?id=${user.id}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
<c:if test="${page>1}">
    <span><a href="user/list?page=${page-1}">上一页</a></span>
</c:if>
<c:if test="${page<pageCount}">
    <span><a href="user/list?page=${page+1}">下一页</a></span>
</c:if>
    <span>第${page}页：</span>
    <span>用户总人数：${userCount}</span>
</body>
</html>