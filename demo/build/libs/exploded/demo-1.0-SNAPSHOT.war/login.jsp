<%--
  Created by IntelliJ IDEA.
  User: MesKaNoVa
  Date: 2/6/2023
  Time: 10:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<h3>Enter your email and password below</h3>
    <form method="post" action="login-servlet">
        <input name="email-field"  style="height: 25px; width: 250px; font-size: 20px;" type="email" placeholder="Enter Email" required>
        <br>
        <br>
        <input name="password-field" style="height: 25px; width: 250px; font-size: 20px;" type="password" placeholder="Enter Password" required>
        <br>
        <br>
        <input style="height: 40px; width: 60px; font-size: 15px;" value="Login" type="submit">
    </form>
</body>
</html>
