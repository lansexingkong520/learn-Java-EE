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
    <title>帖子管理列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>

<body>
<table id="test" class="layui-table" lay-even="" lay-skin="row">
    <thead>
    <tr>
        <th>id</th>
        <th>title</th>
        <th>content</th>
        <th>time</th>
        <th>设为精华</th>
        <th>置顶</th>
        <th>删除</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${requestScope.postList}" var="post" varStatus="s">
        <tr>
            <td>${post.pid}</td>
            <td>${post.title}</td>
            <td>${post.content}</td>
            <td>${post.time}</td>
            <td><a href="emod?pid=${post.pid}">设为精华</a></td>
            <td><a href="tmod?pid=${post.pid}">置顶</a></td>
            <td><a href="postdel.do?pid=${post.pid}">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${page>1}">
    <span><a href="postList?page=${page-1}">上一页</a></span>
</c:if>
<c:if test="${page<pageCount}">
    <span><a href="postList?page=${page+1}">下一页</a></span>
</c:if>
<span>共${pageCount}页</span>&nbsp;&nbsp;&nbsp;&nbsp;
<span>帖子总数：${postCount}</span>

</body>
</html>
