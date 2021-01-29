<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/1/14
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>帖子列表</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>

<body>
<table id="test" class="layui-table" lay-even="" lay-skin="row">
    <colgroup>
        <col width="100">
        <col width="200">
        <col width="150">
        <col width="150">
    </colgroup>
    <thead>
    <tr>
        <td>是否精华</td>
        <th>主题</th>
        <th>发帖人</th>
        <th>时间</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${post}" var="post" varStatus="s">
        <tr>
            <c:if test="${post.essence==1}">
                <td style="color: orange">精华</td>
            </c:if>
            <c:if test="${post.essence==0}">
                <td></td>
            </c:if>
            <td><a href="commentList?pid=${post.pid}"}>${post.title}</a></td>
            <td>${post.uname}</td>
            <td>${post.time}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<c:if test="${page>1}">
    <span><a href="list?page=${page-1}">上一页</a></span>
</c:if>
<c:if test="${page<pageCount}">
    <span><a href="list?page=${page+1}">下一页</a></span>
</c:if>
<span>共${pageCount}页</span>&nbsp;&nbsp;&nbsp;&nbsp;
<span>帖子总数：${postCount}</span>

</body>
</html>