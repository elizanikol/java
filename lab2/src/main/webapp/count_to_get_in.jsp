<%--
  Created by IntelliJ IDEA.
  User: elizabethnikolaeva
  Date: 03/10/2019
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sum calculation</title>
</head>
<body>
<form method="Get" action="Servlet">
    <div>
        <input type="hidden" id="hash" name="hash" value=${hash}>
    </div>
    <div>
        Calculate sum of two digits: ${digit1}, ${digit2}:
    </div>
</form>
<form method="Post" action="servlet">
    <div>
        <label for="res">Sum:</label>
        <input type="number" id="res" name="res" min="-250" max="694">
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>
