
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Mice-tr0 - Login</title>

    <style type="text/css">
      input[type=submit]{
        background-color: darkred; /* Red */
        border: 2px solid darkred;
        color: white;
        padding: 10px 25px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        border-radius: 4px;
        margin: 4px 2px;
      }
      input[type=submit]:hover{
          background-color: white;
          border: 2px solid darkred;
          color: darkred;
      }
    </style>

  </head>
  <body>
    <h1> Please Enter Your Account Information</h1>

    <form action="${pageContext.servletContext.contextPath}/profile" method="get">
      Username:<br>
      <input type="text" name="username" value=${login.usrnm}><br>
      Password:<br>
      <input type="password" name="password" value=${login.psw}><br><br>
      <input type="submit" value="Login">
    </form>

    <h2>Don't Have an Account?</h2>

    <form action="${pageContext.servletContext.contextPath}/createAccount" method="get">
        <input name="goToCreateAccount" type="submit" value="Create Account" />
    </form>

  </body>
</html>
