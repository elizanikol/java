<%--
  Created by IntelliJ IDEA.
  User: elizabethnikolaeva
  Date: 16/10/2019
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
</head>
<body>
<form method="Post" action="ServletSignUp">
    <div>
        Create login and password for your new account
    </div>
    <div>
        <label for="login">Login:</label>
        <input type="text" id="login" name="login">
    </div>
    <div>
        <label for="login">Password:</label>
        <input type="text" id="password" name="password">
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</body>
</html>
