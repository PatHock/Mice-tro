<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%--minimize white flashes between page changes--%>
        <style>html{background-color: #323232;}</style>

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

        <%--</div>--%>
        <%--<div class="wrapper">--%>
            <%--<div class="sidebar">--%>
                <%--<div class="sidebar-header" align="center">--%>
                    <%--<h3>ABC Notation</h3>--%>
                    <%--<hr>--%>
                <%--</div>--%>
                <%--<h4>What is it?</h4>--%>
                <%--Find out by visiting the--%>
                <%--<a href="http://abcnotation.com/blog/2010/01/31/how-to-understand-abc-the-basics/">ABC notation website</a>--%>
            <%--</div>--%>
        <%--</div>--%>

        <div class="container theme-showcase" role="main" style="margin-top: 1rem" id="main-div">
            <div class="page-header">
                <h1 align="center">Composition Editor</h1>
            </div>

            <div id="compWindow" class="container" style="background-color: white" align="center">

                <div id="paper" class="paper amber lighten-4 abcjs-containerpaper"></div>
                <hr>

                <div id="midi">
                    <div class="abcjs-inline-midi abcjs-midi-0">
                        <span class="abcjs-data" style="display: none;"></span>
                        <button type="button" class="abcjs-midi-reset abcjs-btn"
                                title="Click to go to beginning of composition"></button>
                        <button type="button" class="abcjs-midi-start abcjs-btn" title="Click to play/pause"></button>
                        <button type="button" class="abcjs-midi-progress-background"
                                title="Click to change playback position.">
                            <span class="abcjs-midi-progress-indicator"></span>
                        </button>
                        <span class="abcjs-midi-clock">0:00</span>
                    </div>
                </div>

                <div id="warnings-id"></div>
                <hr>
                <textarea name="abcText" id="abcText"></textarea>
                <hr>
                <div id="midi-download"></div>
            </div>

            <button type="button" class="btn-secondary" id="save_btn" name="Save Composition">Save Composition</button>

            <form action="profile" method="get">
                <input name="goToProfile"
                       type="submit"
                       value="Back to Profile"/>
            </form>
        </div>

        <script src="js/dist/composition.bundle.js"></script>
    </body>
</html>
