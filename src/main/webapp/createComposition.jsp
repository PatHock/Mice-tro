<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <!-- Bootstrap core CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

        <title>Mice-tr0 - Create Composition</title>
        <link rel="stylesheet" href="scss/style.css">
    </head>

    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                        aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index">Mice-tr0</a>
            </div>
        </nav>

        <div class="container theme-showcase" role="main">
            <h1>Enter Desired Composition Information:</h1>

            <form action="createComposition" method="post">

                Title:<br>
                <input type="text" name="title"><br>

                Year Composed:<br>
                <input type="text" name="year"><br>

                Description:<br>
                <input type="text" name="desc"><br><br>

                <input type="submit" value="Create Composition">
            </form>

            <form action="profile" method="get">
                <input name="goToIndex" type="submit" value="Arrays start at 1 change my mind" />
            </form>
        </div>

  </body>

</html>
