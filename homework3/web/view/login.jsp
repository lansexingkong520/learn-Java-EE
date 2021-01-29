<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/12/24
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
    <form method="post" action="view/login.do">
<%--        用户名：<input type="text" name="username" value="${username}"><br>--%>
<%--        密码：<input type="password" name="password" value="${password}"><br>--%>
        用户名：<input type="text" name="username"><br>
        密码：<input type="password" name="password"><br>
        验证码：<input type="text" name="inputCode"><img id="myImage" src="validCode" width="80" height="30" onclick="myReload()" title="看不清换一张"><br>
        保存密码：<input type="checkbox" name="saveUN"><br>
        <input type="submit" value="登录">&nbsp;&nbsp;
        <input type="reset" value="重置"><br>
        <a href="view/register.jsp">注册</a><br>
    </form>
    <script type="text/javascript">
        function myReload() {
            document.getElementById("myImage").src="validCode?num="+Math.random();
        }
    </script>
</body>
</html>
