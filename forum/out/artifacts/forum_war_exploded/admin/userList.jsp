<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 2021/1/11
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户管理列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>

<body>
<table id="test" class="layui-table" lay-even="" lay-skin="row">
    <colgroup>
        <col width="200">
        <col width="150">
        <col width="150">
    </colgroup>
    <thead>
    <tr>
        <th>用户id</th>
        <th>用户名</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>

    <c:forEach items="${requestScope.userList}" var="user" varStatus="s">
        <tr>
            <td>${user.uid}</td>
            <td>${user.name}</td>
            <td><a href="userdel.do?uid=${user.uid}">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${page>1}">
    <span><a href="userList?page=${page-1}">上一页</a></span>
</c:if>
<c:if test="${page<pageCount}">
    <span><a href="userList?page=${page+1}">下一页</a></span>
</c:if>
<span>共${pageCount}页</span>&nbsp;&nbsp;&nbsp;&nbsp;
<span>用户人数：${userCount}</span>

</body>
</html>
