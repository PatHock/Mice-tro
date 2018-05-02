<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <link rel="icon" href="favicon.ico">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
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
                <h1 align="center">Composition Editor</h1>
            </div>

            <div id="compWindow" class="container" style="background-color: white" align="center">
                <div id="warnings"></div>
                <hr>
                <div id="midi"></div>
                <div id="canvas"></div>
                <hr>
            </div>

<div id="compText" class="container" style="background-color: white" align="center">
<textarea id="abc" cols="80" rows="15">X: 1
T: Cooley's
M: 4/4
L: 1/8
R: reel
K: Emin
|:D2|EB{c}BA B2 EB|~B2 AB dBAG|FDAD BDAD|FDAD dAFD|@
EBBA B2 EB|B2 AB defg|afe^c dBAF|DEFD E2:|
|:gf|eB B2 efge|eB B2 gedB|A2 FA DAFA|A2 FA defg|
eB B2 eBgB|eB B2 defg|afe^c dBAF|DEFD E2:|
</textarea>
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
