<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <link rel="icon" href="favicon.ico">

        <title>Mice-tr0 - Profile</title>
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
                    <li class="active nav-item">
                        <a class="nav-link" href="profile">Profile</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="logout">Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container theme-showcase" role="main" style="margin-top: 1rem">
            <div class="page-header">
                <h1 id="pageTitle" class="display-4" align="center"></h1>
            </div>

            <h2>Select Composition to Edit:</h2>
            <form action="profile" method="post">
            </form>

            <div id="compositionMenu" class="list-group"></div>


            <form action="createComposition" method="get">
                <input name="goToCreateComposition"
                       type="submit"
                       value="Create New Composition " />
            </form>

            <form action="index" method="get">
                <input name="goToIndex"
                       type="submit"
                       value="Delete Account" />
            </form>
        </div>
        <%--Webpack entry point below--%>
        <script src="js/dist/profile.bundle.js"></script>
  </body>

</html>