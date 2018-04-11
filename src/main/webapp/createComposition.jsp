
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

    <head>
        <title>Mice-tr0 - Create Composition</title>
        <link rel="stylesheet" href="styles/style.css">
    </head>

    <body>
        <h1>Enter Desired Composition Information:</h1>

        <form action="${pageContext.servletContext.contextPath}/createComposition" method="post">

            Title:<br>
            <input type="text"
                   name="title"
                   value=${createC.title}><br>

            Year Composed:<br>
            <input type="text"
                   name="year"
                   value=${createC.year}><br>

            Description:<br>
            <input type="text"
                   name="desc"
                   value=${createC.desc}><br><br>

            <input type="submit"
                   value="Create Composition">
        </form>

        <if test="${! empty invalidInput}">
            ${invalidInput}<br>
        </if>

        <if test="${! empty invalidNum}">
            ${invalidNum}<br>
        </if>

        <form action="${pageContext.servletContext.contextPath}/profile" method="get">
            <input name="goToIndex"
                   type="submit"
                   value="I Changed My Mind" />
        </form>

  </body>

</html>
