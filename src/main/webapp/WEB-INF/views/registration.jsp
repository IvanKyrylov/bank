<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: vanns
  Date: 29.07.2019
  Time: 2:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Bank</title>
</head>
<body>

<h1>Bank</h1>
<h4>Registration</h4>

<p>${message}</p>

<form action='<spring:url value="/registration"/>' method="post">
    <table>
        <tr>

            <td>Username</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td>email</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td><button type="submit">Registration</button></td>
        </tr>
    </table>
</form>
<br/>
</body>
</html>