<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2021/1/12
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>发帖页面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
</head>
<body>

<%--<form method="post" action="addPost">--%>
<%--    帖子主题：<input type="text" name="title" style="width: 300px;height: 20px;"/> <br>--%>
<%--    <textarea maxlength="300" name="content" cols="30" wrap="hard" style="width:300px;height:100px;">请输入...</textarea>--%>
<%--    <input type="submit" value="发布">&nbsp;&nbsp;--%>
<%--    <input type="reset" value="重置"><br>--%>
<%--</form>--%>

<div style="margin-left: 33%;margin-top: 8%">
    <form class="layui-form" action="addPost" method="post">
        <div class="layui-form-item">
            <label class="layui-form-label">帖子主题</label>
            <div class="layui-input-inline">
                <input type="text" name="title" style="height: 20px;width: 200px" required lay-verify="required" placeholder="请输入主题" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item layui-form-text">
            <label class="layui-form-label">帖子内容</label>
            <div class="layui-input-block">
                <textarea name="content" maxlength="300" style="height: 300px;width: 400px"  wrap="hard" placeholder="请输入内容"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="submit" class="layui-btn layui-btn-normal" >发布</button>
                <button type="reset" class="layui-btn layui-btn-normal">重置</button>
            </div>
        </div>
    </form>
</div>
</body>
</html>