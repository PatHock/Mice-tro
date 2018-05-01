<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

  <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
      <!-- Bootstrap core CSS -->
      <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

      <title>Mice-tr0 - Home Page</title>

      <script src="/micetr0/js/dist/app.bundle.js"></script>
      <link rel="stylesheet" href="scss/style.scss">

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

      <%--<div id="testCarousel" class="carousel slide" data-ride="carousel">--%>
          <%--<ol class="carousel-indicators">--%>
              <%--<li data-target="#testCarousel" data-slide-to="0" class="active"></li>--%>
              <%--<li data-target="#testCarousel" data-slide-to="1"></li>--%>
              <%--<li data-target="#testCarousel" data-slide-to="2"></li>--%>
          <%--</ol>--%>

          <%--<div class="carousel-inner" role="listbox">--%>
              <%--<div class="item active">--%>
                  <%--<img src="resources/justBarelyWhite.png" alt="First slide">--%>
                  <%--&lt;%&ndash;<div class="carousel-caption d-none d-md-block">&ndash;%&gt;--%>
                      <%--&lt;%&ndash;<h5>Our team motto</h5>&ndash;%&gt;--%>
                  <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
              <%--</div>--%>
              <%--<div class="item">--%>
                  <%--<img src="https://www.lawrence.edu/mw/styles/large/mw/vphnzmndtr.jpeg?itok=TyFLZ5Lc" alt="Second slide">--%>
              <%--</div>--%>
              <%--<div class="item">--%>
                  <%--<img src="resources/justBarelyWhite.png" alt="Third slide">--%>
              <%--</div>--%>
          <%--</div>--%>
          <%--<a class="left carousel-control" href="#testCarousel" role="button" data-slide="prev">--%>
              <%--<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>--%>
              <%--<span class="sr-only">Previous</span>--%>
          <%--</a>--%>
          <%--<a class="right carousel-control" href="#testCarousel" role="button" data-slide="next">--%>
              <%--<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>--%>
              <%--<span class="sr-only">Next</span>--%>
          <%--</a>--%>
          <%--&lt;%&ndash;<a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">&ndash;%&gt;--%>
              <%--&lt;%&ndash;<span class="carousel-control-prev-icon" aria-hidden="true"></span>&ndash;%&gt;--%>
              <%--&lt;%&ndash;<span class="sr-only">Previous</span>&ndash;%&gt;--%>
          <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
          <%--&lt;%&ndash;<a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">&ndash;%&gt;--%>
              <%--&lt;%&ndash;<span class="carousel-control-next-icon" aria-hidden="true"></span>&ndash;%&gt;--%>
              <%--&lt;%&ndash;<span class="sr-only">Next</span>&ndash;%&gt;--%>
          <%--&lt;%&ndash;</a>&ndash;%&gt;--%>
      <%--</div>--%>

      <div class="container theme-showcase" role="main">
          <div class="jumbotron">
              <div class="page-header">
                  <h1 align="center"> Welcome to Mice-tr0!</h1>
              </div>

              <p> Mice-tr0 is a web application that will allow you to compose music right on your computer!
                  Not only will editing be a breeze, but you, the composer, will also be able to play back the piece
                  as you write it! Create an account to start composing.</p>
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

  </body>
</html>
