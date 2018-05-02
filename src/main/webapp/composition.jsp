<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

        <!-- Bootstrap core CSS -->
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

        <title>Mice-tr0 - Composition 1</title>
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
            <div class="page-header">
                <h1 align="center">Composition 1</h1>
            </div>

            <div class="container" style="background-color: white">
                <script src="static/js/abcjs_plugin_latest-min.js"
                        type="text/javascript">
                </script>

                <script type="text/javascript" >
                    ABCJS.plugin.hide_abc = true;
                </script>

                <%--TODO Fix hard coded notes--%>
                X:1
                |:"Em"EEE E2G|"C7"_B2A G2F|"Em"EEE E2G|\
                "C7"_B2A "B7"=B3|"Em"EEE E2G|
                "C7"_B2A G2F|"Em"GFE "D (Bm7)"F2D|\
                1"Em"E3-E3:|2"Em"E3-E2B|:"Em"e2e gfe|
                "G"g2ab3|"Em"gfeg2e|"D"fedB2A|"Em"e2e gfe|\
                "G"g2ab3|"Em"gfe"D"f2d|"Em"e3-e3:|
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
    </body>

</html>
