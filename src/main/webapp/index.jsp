<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<!doctype html>
<html lang="en">

  <head>
      <meta charset="UTF-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1 shrink-to-fit=no">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

      <link rel="icon" href="favicon.ico">

      <title>Mice-tr0 - Home Page</title>

  </head>

  <body>

      <nav class="navbar navbar-expand-md navbar-dark fixed-top">

          <div class="navbar-header">
              <a class="navbar-brand" href="#">Mice-tr0</a>
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

      <div class="container theme-showcase" role="main">

          <div class="jumbotron">
              <div class="page-header">
                  <h1 class="display-4" align="center"> Welcome to Mice-tr0!</h1>
                  <hr>
              </div>

              <p> Mice-tr0 is a web application that will allow you to compose music right on your computer!
                  Not only will editing be a breeze, but you, the composer, will also be able to play back the piece
                  as you write it! Create an account to start composing.</p>
          </div>


          <div id="myCarousel" class="carousel slide" data-ride="carousel">
              <ol class="carousel-indicators">
                  <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                  <li data-target="#myCarousel" data-slide-to="1"></li>
              </ol>
              <div class="carousel-inner">
                  <div class="carousel-item active">
                      <img align="center" class="first-slide" src="resources/notes.jpeg" alt="First slide">
                  </div>
                  <div class="carousel-item">
                      <img align="center" class="second-slide" src="resources/justBarelyWhite.png" alt="Second slide">

                  </div>
              </div>
              <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                  <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                  <span class="sr-only">Previous</span>
              </a>
              <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                  <span class="carousel-control-next-icon" aria-hidden="true"></span>
                  <span class="sr-only">Next</span>
              </a>
          </div>

          <h2> Mice-tr0 Features:</h2>
          <div class="container">

              <p> - Create unlimited compositions</p>
              <p> - Listen to your music at any time during the composing process</p>
              <p> - Save compositions as audio or pdf files </p>
              <p> - Share your music with other mice-tr0 accounts</p>

              <form action="login" method="get">
                  <input name="goToLogIn" type="submit" value="Login" />
              </form>
          </div>


      </div> <!-- container theme-showcase -->
      <script src="js/dist/index.bundle.js"></script>
  </body>
</html>
