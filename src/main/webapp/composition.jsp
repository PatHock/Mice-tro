<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <link rel="icon" href="favicon.ico">

        <title>Mice-tr0 - Composition 1</title>
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
                    <li class="active nav-item">
                        <a class="nav-link" href="index">Home <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#"></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container theme-showcase" role="main" style="margin-top: 1rem">
            <div class="page-header">
                <h1 align="center">Composition 1</h1>
            </div>

            <div class="btn-toolbar" role="toolbar" aria-label="Toolbar with button groups">
                <div class="btn-group mr-2" role="group" aria-label="First group">
                    <button type="button" class="btn btn-secondary">Add Note</button>
                    <button type="button" class="btn btn-secondary">Add Measure</button>
                </div>
            </div>

            <div id="compWindow" class="container" style="background-color: white" align="center">
                <div id="compAbcjs"></div>
            </div>

            <form action="composition" method="get">
                <input name="goToIndex"
                       type="submit"
                       value="Save"/>
            </form>

            <form action="profile" method="get">
                <input name="goToIndex"
                       type="submit"
                       value="Save and Exit Composition 1"/>
            </form>

            <form action="profile" method="get">
                <input name="goToProfile"
                       type="submit"
                       value="Exit Composition 1"/>
            </form>

            <form action="index" method="get">
                <input name="goToIndex"
                       type="submit"
                       value="Log Out" />
            </form>
        </div>

        <script src="js/dist/composition.bundle.js"></script>
    </body>
</html>
