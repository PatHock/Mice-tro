<%--
  Created by IntelliJ IDEA.
  User: patrick
  Date: 3/8/18
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Mice-tr0 - Home Page</title>

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
  <h1>Enter Desired Account Information:</h1>

  <form action="${pageContext.servletContext.contextPath}/profile" method="get">
    Username:<br>
    <input type="text" name="username" value=${usrnm}><br>
    Password:<br>
    <input type="password" name="password" value=${psw}><br><br>
    <input type="submit" value="Create Account">
  </form>

  <form action="${pageContext.servletContext.contextPath}/index" method="get">
    <input name="goToIndex" type="submit" value="I Changed My Mind" />
  </form>

  </body>
</html>
