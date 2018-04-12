<%--@elvariable id="currentUsers" type=""--%>
<%--@elvariable id="totalUsers" type=""--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Mice-tr0 - Profile</title>
        <link rel="stylesheet" href="styles/style.css">
    </head>

    <body>
        <%--<h1>Welcome ${username}</h1>--%>
        <h1>Welcome</h1>
        <h2>Select Composition to Edit:</h2>

        <form action="profile" method="post">
        </form>

        <form action="composition" method="get">
            <input name="goToIndex"
                   type="submit"
                   value="Composition 1" />
        </form>

        <form action="createComposition" method="get">
            <input name="goToCreateComposition"
                   type="submit"
                   value="Create New Composition " />
        </form>

        <form action="index" method="get">
            <input name="goToIndex"
                   type="submit"
                   value="Log Out" />
        </form>

        <form action="index" method="get">
            <input name="goToIndex"
                   type="submit"
                   value="Delete Account" />
        </form>
    <%--${totalUsers}--%>
    <%--${currentUsers}--%>
  </body>

</html>