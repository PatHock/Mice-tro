<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <link rel="icon" href="favicon.ico">

        <title>Mice-tr0 - Create Composition</title>
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

        <div class="container theme-showcase" role="main" style="margin-top: 1rem">
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
        <%--below is webpack entry point--%>
    <script src="js/dist/createComposition.bundle.js"></script>
  </body>
</html>
