
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Mice-tr0 - Create Account</title>

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

  <form action="${pageContext.servletContext.contextPath}/createAccount" method="post">
    Username:<br>
    <input type="text" name="username" value=${createAcc.username}><br>
    Password:<br>
    <input type="password" name="password" value=${createAcc.password}><br><br>
    <input type="submit" value="Create Account">
  </form>

  <if test="${! empty failedCreation}">
    ${failedCreation}<br>
  </if>

  <form action="${pageContext.servletContext.contextPath}/index" method="get">
    <input name="goToIndex" type="submit" value="I Changed My Mind" />
  </form>

  </body>
</html>
