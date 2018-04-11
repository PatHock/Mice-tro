
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Mice-tr0 - Login</title>
        <link rel="stylesheet" href="styles/style.css">
    </head>

    <body>
        <h1> Please Enter Your Account Information</h1>

        <form action="${pageContext.servletContext.contextPath}/login" method="post">

            Username:<br>
            <input type="text"
                   name="username"
                   value=${login.username}>
            <br>

            Password:<br>
            <input type="password"
                   name="password"
                   value=${login.password}>
            <br><br>

            <input type="submit"
                   value="Login">
        </form>

        <if test="${! empty failedLoginError}">
            ${failedLoginError}<br>
        </if>

        <h2>Don't Have an Account?</h2>

        <form action="${pageContext.servletContext.contextPath}/createAccount" method="get">
            <input name="goToCreateAccount"
                   type="submit"
                   value="Create Account"/>
        </form>

  </body>

</html>
