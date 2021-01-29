<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/1/17
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>简易论坛</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
</head>

<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo">论坛管理端</div>
        <!-- 用户信息模块-->
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://localhost:8080/display?photoUrl=${user.pic}" class="layui-nav-img">${user.name}
                </a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree" lay-filter="test">
                <li class="layui-nav-item">
                    <a class="" href="userList" target="ifr">管理用户</a>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="postList" target="ifr">管理帖子</a>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!--实现页面的局部跳转-->
        <iframe src="" width="100%" height="100%" name="ifr">Hello 欢迎您的光临！</iframe>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © five.com - 开发者
    </div>
</div>
<script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
<script>
    //JavaScript代码区域
    layui.use('element', function() {
        var element = layui.element;
    });
</script>
</body>

</html>
