<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<html>
<head>
  <title>TODO主页</title>
  <link rel="stylesheet" type="text/css" href="<c:url value="/static/bower_components/todomvc-app-css/index.css" />" />
  <link rel="stylesheet" href="<c:url value="/static/bower_components/bootstrap/dist/css/bootstrap.css" />" />
</head>
<body>

<header id="header">
  <h1>ToDos</h1>
  <a href="users" class="btn btn-primary btn-sm" role="button">用户列表</a>
  <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
</header>

<section id="main" style="display: block;">
  <ul id="todo-list">

    <c:forEach items="${allToDos}" var="toDo">
      <li data-id="${toDo.id}" ${toDo.completed==true? "class='completed'":""}>
        <input class="hidden" value="${toDo.completed}">
        <div class="view">
          <label>${toDo.title}</label>
          <button class="destroy"></button>
        </div>
        <input class="edit" value="${toDo.title}">
      </li>
    </c:forEach>

  </ul>
</section>

<sec:authorize access="hasRole('ROLE_ADMIN')">
<h1>The title only for Admin</h1>
</sec:authorize>
<script  src="<c:url value="/static/bower_components/jquery/dist/jquery.js" /> ></script>

</body>
</html>