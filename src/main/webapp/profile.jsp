
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Mice-tr0 - Profile</title>

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

  </head>
  <body>
  <h1>Welcome User!</h1>

  <h2>Select Composition to Edit:</h2>

  <form action="${pageContext.servletContext.contextPath}/composition" method="get">
    <input name="goToIndex" type="submit" value="Composition 1" />
  </form>

  <form action="${pageContext.servletContext.contextPath}/createComposition" method="get">
    <input name="goToCreateComposition" type="submit" value="Create New Composition " />
  </form>

  <form action="${pageContext.servletContext.contextPath}/index" method="get">
    <input name="goToIndex" type="submit" value="Log Out" />
  </form>

  <form action="${pageContext.servletContext.contextPath}/index" method="get">
    <input name="goToIndex" type="submit" value="Delete Account
" />
  </form>

  </body>
</html>
