<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>

<head>
  <title>TodoMVC</title>
  <link rel="stylesheet" href="<c:url value="/static/bower_components/todomvc-common/base.css"/>">
  <link rel="stylesheet" href="<c:url value="/static/bower_components/todomvc-app-css/index.css"/>">
</head>


<body><h1>${message}</h1>
<section id="todoapp">
  <header id="header">
    <h1>todos</h1>
    <input id="new-todo" placeholder="What needs to be done?" autofocus>
  </header>

  <section id="main">
    <input id="toggle-all" type="checkbox">

    <ul id="todo-list">
      <c:forEach items="${todolist}" var="todo">
        <li
                <c:choose>
                  <c:when test="${todo.completed}"> class='completed' </c:when>
                  <c:otherwise> class="active" </c:otherwise>
                </c:choose>
                data-id="${todo.id}">
            <%--<li class="active" data-id="${todo.id}">--%>
          <div class="view">
            <input class="toggle" type="checkbox"
            <c:choose>
            <c:when test="${todo.completed}"> checked=true </c:when>
              <c:otherwise></c:otherwise>
            </c:choose>
                    >
            <label>${todo.title}</label>
            <button class="destroy"></button>
          </div>
          <input class="edit" value="${todo.title}">
        </li>
      </c:forEach>
    </ul>
  </section>

  <footer id="footer">
    <span id="todo-count"><strong>${fn:length(todolist)}</strong> items left</span>
    <ul id="filters">
      <li>
        <a href="/all">All</a>
      </li>
      <li>
        <a href="/active">Active</a>
      </li>
      <li>
        <a href="/completed">Completed</a>
      </li>
    </ul>
    <button id="clear-completed">Clear completed</button>
  </footer>
</section>




<footer id="info">
  <p>Double-click to edit a todo</p>
  <p>Part of <a href="http://todomvc.com">TodoMVC</a></p>
</footer>


<script src="<c:url value="/static/bower_components/jquery/dist/jquery.min.js"/>"></script>
<script src="<c:url value="/static/js/index.js"/>"></script>

</body>
</html>