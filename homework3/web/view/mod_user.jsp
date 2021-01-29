<%--
  Created by IntelliJ IDEA.
  User: admin、
  、
  Date: 2020/11/20
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
    <h1>修改用户</h1>
    <form method="post" action="view/mod.do">
        id：<input type="text" name="id" value="${oldUser.id}" readonly><br>
        姓名：<input type="text" name="name" value="${oldUser.name}"><br>
        密码：<input type="text" name="password" value="${oldUser.password}"><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
