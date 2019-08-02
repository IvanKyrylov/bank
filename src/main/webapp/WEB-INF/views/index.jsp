<%--
  Created by IntelliJ IDEA.
  User: vanns
  Date: 02.08.2019
  Time: 4:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Bank</title>
</head>
<body>
<h1>Test</h1>
<h2>${message}</h2>

<form action="/logout" method="post">
    <input type="hidden"
           name="${_csrf.parameterName}"
           value="${_csrf.token}"/>
    <input value="Logout" type="submit">
</form>
</body>
</html>
