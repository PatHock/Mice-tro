
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Mice-tr0 - Composition 1</title>

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
  <h1>Composition 1</h1>

  <script src="../static/js/abcjs_plugin_latest-min.js" type="text/javascript"></script>
  <script type="text/javascript">
      ABCJS.plugin.hide_abc = true;
  </script>

  X:1
  |:"Em"EEE E2G|"C7"_B2A G2F|"Em"EEE E2G|\
  "C7"_B2A "B7"=B3|"Em"EEE E2G|
  "C7"_B2A G2F|"Em"GFE "D (Bm7)"F2D|\
  1"Em"E3-E3:|2"Em"E3-E2B|:"Em"e2e gfe|
  "G"g2ab3|"Em"gfeg2e|"D"fedB2A|"Em"e2e gfe|\
  "G"g2ab3|"Em"gfe"D"f2d|"Em"e3-e3:|

  <form action="${pageContext.servletContext.contextPath}/composition" method="get">
    <input name="goToIndex" type="submit" value="Save" />
  </form>

  <form action="${pageContext.servletContext.contextPath}/profile" method="get">
    <input name="goToIndex" type="submit" value="Save and Exit Composition 1" />
  </form>

  <form action="${pageContext.servletContext.contextPath}/profile" method="get">
    <input name="goToProfile" type="submit" value="Exit Composition 1" />
  </form>

  <form action="${pageContext.servletContext.contextPath}/index" method="get">
    <input name="goToIndex" type="submit" value="Log Out" />
  </form>

  </body>
</html>
