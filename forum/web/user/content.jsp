<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2021/1/14
  Time: 23:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${post.title}</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/layui/css/layui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/layui/layui.js"></script>
    <link rel="stylesheet" href="/css/content.css">
</head>
<body>
<div class="uid">
    发帖人:${post.uname}
</div>
<div class="pic">
    <img id="touxiang" src="http://localhost:8080/display?photoUrl=${post.upic}" class="layui-nav-img">
</div>
<div class="neironglie">
    <div class="title">
        主题：${post.title}<br>
    </div>
    <div class="content">
        内容：${post.content}
    </div>

    <!-- 评论展示-->
    <div class="comment">
        <input type="hidden" name="pid" value="${post.pid}">
        <span>评论区：</span><br>
        <c:forEach items="${conment}" var="conment" varStatus="s">
            <span>${conment.uname}</span>：
            <span>${conment.content}</span><br>
        </c:forEach>
        <c:if test="${page>1}">
            <span><a href="commentList?page=${page-1}&pid=${post.pid}">上一页</a></span>
        </c:if>
        <c:if test="${page<pageCount}">
            <span><a href="commentList?page=${page+1}&pid=${post.pid}">下一页</a></span>
        </c:if>
        <span>共${pageCount}页</span>&nbsp;&nbsp;&nbsp;&nbsp;
        <span>评论总数${conmentCount}</span>
    </div>

    <!-- 评论书写框  -->
    <div class="reply">
        <form action="addComment" method="post">
            <input type="hidden" name="pid" value="${post.pid}">
            <br style="clear:both"/>
            <textarea style="height:80px;width: 200px" name="content" placeholder="评论"></textarea>
            <%--        <br style="clear:both"/>--%>
            <input type="submit" name="submit" class="button" value="评论"/>
        </form>
    </div>
</div>
</body>
</html>
