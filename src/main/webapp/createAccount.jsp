<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>
      <title>Mice-tr0 - Create Account</title>
      <link rel="stylesheet" href="css/style.css">
      <script src='https://www.google.com/recaptcha/api.js'></script>
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

      <div class="g-recaptcha" data-sitekey="6Lf6aFMUAAAAACSOyNEl5DOa8krAnV3PHQuKdkFD"></div>

      <form action="index" method="get">
          <input name="goToIndex"
                 type="submit"
                 value="I Changed My Mind"/>
      </form>
  </body>
</html>
