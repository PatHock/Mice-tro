
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Mice-tr0 - Home Page</title>

    <style type="text/css">
      input[type=submit]{
          background-color: darkred; /* Red */
          border: 2px solid darkred;
          color: white;
          padding: 10px 25px;
          text-align: center;
          text-decoration: none;
          display: inline-block;
          font-size: 16px;
          border-radius: 4px;
          margin: 4px 2px;
      }
      input[type=submit]:hover{
          background-color: white;
          border: 2px solid darkred;
          color: darkred;
      }

    </style>

    <script src="../build/Tone.js"></script>
    <script src="./scripts/jquery.min.js"></script>
    <script src="./scripts/draggabilly.js"></script>
    <script src="./scripts/StartAudioContext.js"></script>
    <script src="./scripts/Interface.js"></script>
    <script src="https://tonejs.github.io/Logo/build/Logo.js"></script>

  </head>


  <body>
  <h1> Welcome to Mice-tr0!</h1>

  <p> Mice-tr0 is a web application that will allow you to compose music right on your computer!
  Not only will editing be a breeze, but you, the composer, will also be able to play back the piece
  as you write it! Create an account to start composing.</p>

  <h2> Mice-tr0 Features:</h2>

  <p> - Create unlimited compositions</p>
  <p> - Listen to your music at any time during the composing process</p>
  <p> - Save compositions as audio or pdf files </p>
  <p> - Share your music with other mice-tr0 accounts</p>

  <form action="${pageContext.servletContext.contextPath}/login" method="get">
    <input name="goToLogIn" type="submit" value="Login" />
  </form>


  </body>
</html>
