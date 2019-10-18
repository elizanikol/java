<%--
  Created by IntelliJ IDEA.
  User: elizabethnikolaeva
  Date: 12/10/2019
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in</title>
</head>
<body>
<form method="Post" action="ServletSignIn">
    <div>
        Please, enter your login and password to sign in to your account
    </div>
    <div>
        <a href ="/registration_war_exploded/sign_up.jsp">sign up</a>
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