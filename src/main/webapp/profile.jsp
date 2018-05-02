<%--@elvariable id="currentUsers" type=""--%>
<%--@elvariable id="totalUsers" type=""--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Bootstrap core CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

        <title>Mice-tr0 - Profile</title>
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
        <div class="container theme-showcase" role="main">
            <div class="page-header">
                <h1 align="center">Welcome</h1>
            </div>

            <h2>Select Composition to Edit:</h2>
            <form action="profile" method="post">
            </form>

            <form action="composition" method="get">
                <input name="goToIndex"
                       type="submit"
                       value="Composition 1" />
            </form>

            <form action="createComposition" method="get">
                <input name="goToCreateComposition"
                       type="submit"
                       value="Create New Composition " />
            </form>

            <form action="index" method="get">
                <input name="goToIndex"
                       type="submit"
                       value="Log Out" />
            </form>

            <form action="index" method="get">
                <input name="goToIndex"
                       type="submit"
                       value="Delete Account" />
            </form>
        </div>

  </body>

</html>