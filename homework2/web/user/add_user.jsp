<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/11/20
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
    <form method="post" action="add.do">
        id：<input type="text" name="id"><br>
        姓名：<input type="text" name="name"><br>
        密码：<input type="text" name="password"><br>
        <input type="submit" value="提交">
        <a href="../list">返回用户列表</a>
    </form>
</body>
</html>
