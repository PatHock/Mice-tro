<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Mice-tr0 - Login</title>
        <link rel="stylesheet" href="css/style.css">

        <%--TODO: Put Javascript in webpack--%>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script type="text/javascript" src="js/login.js"></script>
    </head>

    <body>
        <h1> Please Enter Your Account Information</h1>

        <form  action="login" id="loginForm" method="post">
            Username:<br>
            <input type="text" name="username">
            <br>

            Password:<br>
            <input type="password" name="password">
            <br><br>

            <input type="submit" value="Login">
        </form>

        <div id="loginErrMessDiv"></div>

        <h2>Don't Have an Account?</h2>

        <form action="createAccount" method="get">
            <input name="goToCreateAccount"
                   type="submit"
                   value="Create Account"/>
        </form>
  </body>
</html>
