<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/12/24
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <style>
        .register{
            margin-left: 39%;
            margin-top: 12%;
        }
    </style>
</head>
<body>
<div class="register">
    <h2 style="margin-left: 14%">用户注册</h2>
    <br>
    <form class="layui-form" action="register" method="post" enctype="multipart/form-data">
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
            <label class="layui-form-label">性别</label>
            <div class="layui-input-block">
                <input type="radio" name="sex" value="男" title="男">
                <input type="radio" name="sex" value="女" title="女">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">上传头像</label>
            <div class="layui-input-block">
                <input type="file" name="pic">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn layui-btn-normal">注册</button>&nbsp;&nbsp;&nbsp;
                <a  href="http://localhost:8080/" class="layui-btn layui-btn-normal">返回</a>
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
