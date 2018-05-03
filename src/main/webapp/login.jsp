<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%--minimize white flashes between page changes--%>
        <style>html{background-color: #323232;}</style>

        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <link rel="icon" href="favicon.ico">

        <title>Mice-tr0 - Login</title>
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

        <div class="container theme-showcase" role="main">

            <div class="container ">
                <form class="form-signin" id ="loginForm">
                    <h2 class="form-signin-heading">Please sign in</h2>
                    <label for="inputUsername" class="sr-only">Email address</label>
                    <input type="text" name="username" id="inputUsername" class="form-control" placeholder="Username" required autofocus>
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                    <message id="loginErrMsg"></message>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div> <!-- /container -->

            <h2>Don't Have an Account?</h2>

            <form action="createAccount" method="get">
                <input name="goToCreateAccount"
                       type="submit"
                       value="Create Account"/>
            </form>
        </div>

        <script src="js/dist/login.bundle.js"></script>
  </body>
</html>
