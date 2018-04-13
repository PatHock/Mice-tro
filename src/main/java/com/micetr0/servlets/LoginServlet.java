package com.micetr0.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import com.micetr0.controller.AccountController;
import org.springframework.dao.DataIntegrityViolationException;

@WebServlet(
        name = "LoginServlet",
        urlPatterns = {"/login"},
        description = "Whatever this servlet does, describe here",
        loadOnStartup = 1
)
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String text = "Very Dank, ajax works";
        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));

        resp.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8"); // You want world domination, huh?
        resp.getWriter().write(text);       // Write response body.


        if (ajax) {
            // Handle ajax (JSON or XML) response.
            System.out.println("LoginServlet AJAX doGet");
        } else {
            System.out.println("LoginServlet doGet");
            // Handle regular (JSP) response.
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        AccountController controller = new AccountController();
        Boolean isValidCredentials = false;

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String invalidCredentialsMsg = "Incorrect username/password combination. Please try again.";

        System.out.println(username);
        System.out.println(password);

        resp.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8"); // You want world domination, huh?


        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
        if (ajax) {
            // Handle ajax (JSON or XML) response.
            System.out.println("Ajax request on LoginServlet doPost");

        } else {
            System.out.println("doPost on LoginServlet, not Ajax");
            // Handle regular (JSP) response.
        }

        try {
            isValidCredentials =  controller.logIn(username, password);
        } catch(DataIntegrityViolationException e) {
            // TODO: Redirect to failure page
            //resp.sendError(500, "Welp, something went wrong :(");
            System.out.println(e.getCause() + "More than one account with specified username and password");
        }


        if(isValidCredentials) {
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            //TODO: Let ajax know to redirect, currently prints contents of profile page
            req.getRequestDispatcher("/profile.jsp").forward(req, resp);
        }
        else {
            resp.getWriter().write(invalidCredentialsMsg);       // Write response body.
        }


    }

}
