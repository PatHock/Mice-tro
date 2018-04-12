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

        System.out.println("Login Servlet: doGet");

        req.getRequestDispatcher("/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        AccountController controller = new AccountController();

        Boolean isValidCredentials = false;

            String username = req.getParameter("username");
            String password = req.getParameter("password");
//            resp.setContentType("text/html");
//            resp.setCharacterEncoding("UTF-8");
            PrintWriter out = resp.getWriter();

            System.out.println(username);
            System.out.println(password);

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
//                ServletContext context = getServletContext();

                req.setAttribute("message", null);
                req.getRequestDispatcher("/profile.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("message", "Invalid login");
                req.getRequestDispatcher("/login.jsp").forward(req, resp);
            }



    }

}
