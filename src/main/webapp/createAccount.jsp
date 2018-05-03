<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <%--minimize white flashes between page changes--%>
      <style>html{background-color: #323232;}</style>

      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

      <link rel="icon" href="favicon.ico">

      <title>Mice-tr0 - Create Account</title>
  </head>

  <body>
      <nav class="navbar navbar-expand-md navbar-dark fixed-top">
          <div class="navbar-header">
              <a class="navbar-brand" href="index">Mice-tr0</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarCollapse">
              <ul class="nav navbar-nav">
                  <li class="nav-item">
                      <a class="nav-link" href="index">Home <span class="sr-only">(current)</span></a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="profile">Profile</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="logout">Logout</a>
                  </li>
              </ul>
          </div>
      </nav>

      <h1 style="margin-top: 1rem">Enter Desired Account Information:</h1>

      <form action="createAccount" method="post">
          Username:<br>
          <input type="text" name="username"
          ><br>

          Password:<br>
          <input type="password" name="password"
          ><br><br>

          <input type="submit" value="Create Account">
      </form>
      <%--Webpack entry point below--%>
      <script src="js/dist/createAccount.bundle.js"></script>
  </body>
</html>
