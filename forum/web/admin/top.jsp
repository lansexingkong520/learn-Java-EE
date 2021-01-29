<%--
  Created by IntelliJ IDEA.
  User: a'su's
  Date: 2021/1/13
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设置置顶</title>
</head>
<body>
<form action="top" method="post">
    id：<input type="text" name="pid" value="${requestScope.post.pid}" readonly><br>
    主题：<input type="text" name="title" value="${requestScope.post.title}" readonly><br>
    内容：<input type="text" name="content" value="${requestScope.post.content}" readonly><br>
    <input type="checkbox" name="top" value="1">置顶
    <input type="submit" value="确认修改"><br>
    <a href="postList">管理帖子</a>
</form>
</body>
</html>
