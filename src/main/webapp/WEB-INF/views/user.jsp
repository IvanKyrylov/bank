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
<h3>Credit Account</h3>

<%--<form action="/userSelect" method="post">--%>
<%--    <input name="createAccount" type="text" v>--%>
<%--    <input type="submit" value="Submit">--%>
<%--    <input type="hidden"--%>
<%--           name="${_csrf.parameterName}"--%>
<%--           value="${_csrf.token}"/>--%>
<%--</form>--%>
<table>
    <tr>
        <th>Account number</th>
        <th>Credit limit</th>
        <th>Credit</th>
        <th>Percent rate</th>
        <th>Date of receiving</th>
        <th>Return time</th>
    </tr>
    <c:forEach var="credit" items="${creditList}">
        <tr>
            <td>${credit.num}</td>
            <td>${credit.creditLimit}</td>
            <td>${credit.credit}</td>
            <td>${credit.interestRate}</td>
            <td>${credit.createTime}</td>
            <td>${credit.return_time}</td>
        </tr>
    </c:forEach>
</table>
<table>
    <tr>
        <th>Account number</th>
        <th>Deposit amount</th>
        <th>Rate</th>
    </tr>
    <c:forEach var="deposit" items="${depositList}">
        <tr>
            <td>${deposit.num}</td>
            <td>${deposit.deposit_amount}</td>
            <td>${deposit.rate}</td>
        </tr>
    </c:forEach>
</table>

    <form action="/logout" method="post">
        <input type="hidden"
               name="${_csrf.parameterName}"
               value="${_csrf.token}"/>
        <input value="Logout" type="submit">
    </form>

<%--<h2>Add</h2>--%>
<%--<c:url value = "/add" var="add"/>--%>
<%--<a href ="${add}">Add new users</a>--%>
</body>
</html>
