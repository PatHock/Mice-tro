<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
    <head>
        <%--minimize white flashes between page changes--%>
        <style>html{background-color: #323232;}</style>

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

            <div class="container">
                <form id="compAttr">
                    <div class="form-group row">
                        <label for="Title" class="col-sm-2 col-form-label">Title</label>
                        <div class="col-sm-10">
                            <input type="text" name="title" class="form-control " id="title" placeholder="Insert catchy title here">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="year" class="col-sm-2 col-form-label">Year Composed</label>
                        <div class="col-sm-10">
                            <input type="number" name="year" class="form-control" id="year" placeholder="Ex: 2018">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="description" class="col-sm-2 col-form-label">Description</label>
                        <div class="col-sm-10">
                            <input type="text" name="description" class="form-control" id="description" placeholder="Ex: That one dank song I wrote the other night">
                        </div>
                    </div>
                    <button class="btn btn-lg btn-block" type="submit">Create Composition</button>
                </form>
            </div>

            <form action="profile" method="get">
                <input name="goToIndex" type="submit" value="Arrays start at 1 change my mind" />
            </form>
        </div>
        <%--below is webpack entry point--%>
    <script src="js/dist/createComposition.bundle.js"></script>
  </body>
</html>
