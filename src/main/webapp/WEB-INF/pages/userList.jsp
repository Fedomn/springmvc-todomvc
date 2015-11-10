<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" href="<c:url value="/static/bower_components/todomvc-common/base.css" />"  />
    <link rel="stylesheet" href="<c:url value="/static/bower_components/bootstrap/dist/css/bootstrap.css" /> " />

    <title>用户列表</title>
</head>
<body>


<header id="header">
    <h1>用户列表</h1>
    <input id="new-todo" placeholder="请输入一个新用户" autofocus="">
</header>



<section id="main" style="display: block;">
    <ul id="todo-list">
        <c:forEach items="${allUsers}" var="User">
            <li data-id="${User.id}">
                <div class="view">
                    <a href="users/${User.name}/todos">${User.name}</a>
                    <button class="destroy"></button>
                </div>
            </li>
        </c:forEach>
    </ul>
</section>


<script src="<c:url value="/static/bower_components/jquery/dist/jquery.js" />"></script>
<script src="<c:url value="/static/js/user.js" />"></script>
</body>
</html>
