<%--
  Created by IntelliJ IDEA.
  User: a'su's
  Date: 2021/1/12
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>设为精华</title>
</head>
<body>

<form action="ess" method="post">
    id：<input type="text" name="pid" value="${requestScope.post.pid}" readonly><br>
    主题：<input type="text" name="title" value="${requestScope.post.title}" readonly><br>
    内容：<input type="text" name="content" value="${requestScope.post.content}" readonly><br>
    <input type="checkbox" name="essence" value="1">设为精华
    <input type="submit" value="确认修改"><br>
    <a href="postList">管理帖子</a>
</form>
</body>
</html>
