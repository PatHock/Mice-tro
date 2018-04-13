<%--@elvariable id="message" type="java.lang.String"--%>
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<%--<%@ attribute name="isValidCredentials" required="false" type="java.lang.Boolean" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Mice-tr0 - Login</title>
        <link rel="stylesheet" href="styles/style.css">


        <%--TODO: Put Javascript in webpack--%>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <script type="text/javascript">

        $(document).on("click", "#someButton", function() { // When HTML DOM "click" event is invoked on element with ID "somebutton", execute the following function...
            $.get("login", function(responseText) {   // Execute Ajax GET request on URL of "someservlet" and execute the following function with Ajax response text...
                $("#buttonDiv").text(responseText);           // Locate HTML DOM element with ID "somediv" and set its text content with the response text.
            });
        });
        //TODO: Add success/failure methods, use JSON to
        $(document).on("submit", "#loginForm", function(event) {
            var $form = $(this);

            $.post($form.attr("action"), $form.serialize(), function(invalidCredentialsMsg) {
                $("#loginDiv").text(invalidCredentialsMsg);
                // ...
            });
            event.preventDefault(); // Important! Prevents submitting the form.
        });

    </script>

    </head>


    <body>
        <h1> Please Enter Your Account Information</h1>


        <form  action="login" id="loginForm" method="post">
            Username:<br>
            <input type="text" name="username">
                   <%--value=${login.username}>--%>
            <br>

            Password:<br>
            <input type="password" name="password">
                   <%--value=${login.password}>--%>
            <br><br>

            <input type="submit" value="Login">
        </form>


        <div id="loginDiv"></div>

        <button id="someButton"> Press Here</button>
        <div id="buttonDiv"></div>



        <h2>Don't Have an Account?</h2>

        <form action="createAccount" method="get">
            <input name="goToCreateAccount"
                   type="submit"
                   value="Create Account"/>
        </form>
  </body>

</html>
