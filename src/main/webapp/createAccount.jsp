<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>
    <title>Mice-tr0 - Create Account</title>
    <link rel="stylesheet" href="css/style.css">
  </head>

  <body>
      <h1>Enter Desired Account Information:</h1>

      <form action="createAccount" method="post">
          Username:<br>
          <input type="text" name="username"
          ><br>

          Password:<br>
          <input type="password" name="password"
          ><br><br>

          <input type="submit" value="Create Account">
      </form>

      <form action="index" method="get">
          <input name="goToIndex"
                 type="submit"
                 value="I Changed My Mind"/>
      </form>
  </body>
</html>
