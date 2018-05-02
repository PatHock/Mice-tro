<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

      <!-- Bootstrap core CSS -->
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

      <title>Mice-tr0 - Create Account</title>
    <link rel="stylesheet" href="scss/style.css">
  </head>

  <body>
      <nav class="navbar navbar-inverse navbar-fixed-top">
          <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                  <span class="sr-only">Toggle navigation</span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
                  <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="index">Mice-tr0</a>
          </div>
      </nav>

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

  </body>
</html>
