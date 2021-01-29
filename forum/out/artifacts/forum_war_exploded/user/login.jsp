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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <style>
        .login{
            margin-left: 39%;
            margin-top: 12%;
        }
        .myImg{
            margin-left: 57%;
        }
    </style>
</head>
<body>
<div class="login">
    <h2 style="margin-left: 17%">登录</h2>
    <br>
    <form class="layui-form" action="user/login" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">用户名</label>
            <div class="layui-input-inline">
                <input type="text" name="name" lay-verify="title" autocomplete="off">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码</label>
            <div class="layui-input-inline">
                <input type="password" name="pwd" autocomplete="off">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">验证码</label>
            <div class="layui-input-inline">
                <input type="text" name="inputCode" lay-verify="title" autocomplete="off">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-inline">
                <img class="myImg" id="myImage" src="validCode" width="80" height="30" onclick="myReload()" title="看不清换一张"><br>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <input type="radio" name="status" value="1" title="管理员">
                <input type="radio" name="status" value="0" title="用户">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn layui-btn-normal">登录</button>&nbsp;&nbsp;&nbsp;
                <a  href="http://localhost:8080/user/register.jsp" class="layui-btn layui-btn-normal">注册</a>
            </div>
        </div>
    </form>

</div>
<script type="text/javascript">
    function myReload() {
        document.getElementById("myImage").src = "validCode?num=" + Math.random();
    }
</script>
<script>
    layui.use(['form'], function () {
        var form = layui.form;
        form.render('radio');
        });
</script>
</body>
</html>


