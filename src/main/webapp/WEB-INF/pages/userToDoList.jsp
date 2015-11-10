<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
  <title>TODO主页</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/static/bower_components/todomvc-common/base.css" /> ">
  <link rel="stylesheet" href="<c:url value="/static/bower_components/bootstrap/dist/css/bootstrap.css" /> ">
</head>
<body>

<header id="header">
  <h1>todos</h1>
  <a href="/users" class="btn btn-primary btn-lg" role="button">用户列表</a>
  <input id="new-todo" placeholder="What needs to be done?" autofocus="">
  <input id="user_id" hidden="hidden" value="${userId}">
</header>

<section id="main" style="display: block;">
  <ul id="todo-list">
    <c:forEach items="${userToDoList}" var="toDo">
      <li data-id="${toDo.id}" ${toDo.completed==true? "class='completed'":""}>
        <input class="hidden" value="${toDo.completed}">
        <div class="view">
          <input class="toggle" type="checkbox" ${toDo.completed==true?"checked":""}>
          <label>${toDo.title}</label>
          <button class="destroy"></button>
        </div>
        <input class="edit" value="${toDo.title}">
      </li>
    </c:forEach>
  </ul>
</section>
<script  src="<c:url value="/static/bower_components/jquery/dist/jquery.js" />"  ></script>
<script  src="<c:url value="/static/js/todolist.js" />"></script>

</body>
</html>
