<%--
  Created by IntelliJ IDEA.
  User: vanns
  Date: 24.06.2019
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>User</title>
</head>
<body>

<h2>User</h2>
<table>
    <tr>
        <th>id</th>
        <th>username</th>
        <th>email</th>
        <th>password</th>
        <th>create time</th>
        <th>privilege</th>
    </tr>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.email}</td>
            <td>${user.password}</td>
            <td>${user.createTime}</td>
            <td>
                <a href="/edit/${user.id}">edit</a>
                <a href="/delete/${user.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<%--<h2>Add</h2>--%>
<%--<c:url value = "/add" var="add"/>--%>
<%--<a href ="${add}">Add new users</a>--%>
</body>
</html>
