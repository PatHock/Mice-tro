
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Mice-tr0 - Profile</title>
        <link rel="stylesheet" href="styles/style.css">
    </head>

    <body>
        <h1>Welcome ${currUser}</h1>

        <h2>Select Composition to Edit:</h2>

        <form action="${pageContext.servletContext.contextPath}/profile" method="post">

        </form>

        <form action="${pageContext.servletContext.contextPath}/composition" method="get">
            <input name="goToIndex"
                   type="submit"
                   value="Composition 1" />
        </form>

        <form action="${pageContext.servletContext.contextPath}/createComposition" method="get">
            <input name="goToCreateComposition"
                   type="submit"
                   value="Create New Composition " />
        </form>

        <form action="${pageContext.servletContext.contextPath}/index" method="get">
            <input name="goToIndex"
                   type="submit"
                   value="Log Out" />
        </form>

        <form action="${pageContext.servletContext.contextPath}/index" method="get">
            <input name="goToIndex"
                   type="submit"
                   value="Delete Account" />
        </form>
  </body>

</html>