<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
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

      <%--<h1 style="margin-top: 1rem">Enter Desired Account Information:</h1>--%>

      <%--<form action="createAccount" method="post">--%>
          <%--Username:<br>--%>
          <%--<input type="text" name="username"--%>
          <%--><br>--%>

          <%--Password:<br>--%>
          <%--<input type="password" name="password"--%>
          <%--><br><br>--%>

          <%--<input type="submit" value="Create Account">--%>
      <%--</form>--%>

      <div class="container theme-showcase" role="main">

          <%--<div class="container ">--%>
              <%--<form class="form-signin" id ="accountForm">--%>
                  <%--<h2 class="form-account-heading">Please enter desired username and password</h2>--%>
                  <%--<label for="inputUsername" class="sr-only">Username</label>--%>
                  <%--<input type="text" name="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>--%>
                  <%--<label for="inputPassword" class="sr-only">Password</label>--%>
                  <%--<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>--%>
                  <%--<message id="accountErrMsg"></message>--%>
                  <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
              <%--</form>--%>
          <%--</div> <!-- /container -->--%>

          <div class="flip">
              <div class="row justify-content-center">
                  <div class="card" align="center">
                        <div class="face front" align="center">
                            <div class="panel panel-default">
                                <form class="form-horizontal">
                                    <form class="form-signin" id ="loginForm">
                                        <br>
                                        <h1 class="text-center">Please Sign In</h1>
                                        <br>

                                        <label for="inputUsername" class="sr-only">Username</label>
                                        <input type="text" name="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
                                        <label for="inputPassword" class="sr-only">Password</label>
                                        <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                                        <message id="loginErrMsg"></message>
                                        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                                        <p class="text-center">
                                            <a href="#" class="fliper-btn">Create new account?</a>
                                        </p>
                                    </form>
                            </div><%--panel--%>
                        </div><%--face front--%>

                        <div class="face back " align="center">
                            <div class="panel panel-default">
                                <form class="form-signin">
                                    <br>
                                    <h1 class="text-center">Enter Desired Credentials</h1>
                                    <br>

                                    <input class="form-control" placeholder="Username"/>
                                    <input class="form-control" placeholder="Password"/>
                                    <message id="signupErrMsg"></message>
                                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign up!</button>

                                    <p class="text-center">
                                        <a href="#" class="fliper-btn">Already have an account?</a>
                                    </p>
                                </form><!--form-horizontal-->
                            </div><!--panel panel-default-->
                        </div><!--face back-->
                  </div><!-- card-->
              </div>
          </div><!-- flip-->
      </div><!-- container theme-showcase-->


      <%--Webpack entry point below--%>
      <script src="js/dist/createAccount.bundle.js"></script>
  </body>
</html>
