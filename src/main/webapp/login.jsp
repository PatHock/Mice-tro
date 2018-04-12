<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ attribute name="isValidCredentials" required="false" type="java.lang.Boolean" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mice-tr0 - Login</title>
        <link rel="stylesheet" href="styles/style.css">
    </head>

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.js"></script>

    <body>
        <h1> Please Enter Your Account Information</h1>

        <%--<c:set var="isValidCredentials" value="${(empty isValidCredentials) ? 'Default isValidCredentials' : isValidCredentials}" />--%>

        <form action="login" method="post">
            Username:<br>
            <input type="text"
                   name="username">
                   <%--value=${login.username}>--%>
            <br>

            Password:<br>
            <input type="password"
                   name="password">
                   <%--value=${login.password}>--%>
            <br><br>

            <input type="submit"
                   value="Login">
        </form>

        <%--<c:if test="${not empty message}">--%>
            <%--<h1>${message}</h1>--%>
        <%--</c:if>--%>

        <h2>Don't Have an Account?</h2>

        <form action="createAccount" method="get">
            <input name="goToCreateAccount"
                   type="submit"
                   value="Create Account"/>
        </form>
  </body>

</html>
