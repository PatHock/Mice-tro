<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Bootstrap core CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
        <%--<script src="/micetr0/js/dist/app.bundle.js"></script>--%>
        <link rel="stylesheet" href="scss/login.scss">
        <link rel="stylesheet" href="scss/style.scss">


        <%--TODO: Put Javascript in webpack--%>
        <script src="http://code.jquery.com/jquery-latest.min.js"></script>
        <script type="text/javascript" src="js/login.js"></script>

        <title>Mice-tr0 - Login</title>

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
  </body>
</html>
