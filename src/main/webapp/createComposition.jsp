
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Mice-tr0 - Create Composition</title>

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

  <h1>Enter Desired Composition Information:</h1>

  <form action="${pageContext.servletContext.contextPath}/createComposition" method="post">
    Title:<br>
    <input type="text" name="title" value=${createC.title}><br>
    Year Composed:<br>
    <input type="text" name="year" value=${createC.year}><br>
    Description:<br>
    <input type="text" name="desc" value=${createC.desc}><br><br>
      <input type="submit" value="Create Composition">
  </form>

  <if test="${! empty invalidInput}">
    ${invalidInput}<br>
  </if>

  <if test="${! empty invalidNum}">
      ${invalidNum}<br>
  </if>

  <form action="${pageContext.servletContext.contextPath}/profile" method="get">
    <input name="goToIndex" type="submit" value="I Changed My Mind" />
  </form>

  </body>
</html>
