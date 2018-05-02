package com.micetr0.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
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
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));

        resp.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8"); // You want world domination, huh?

        if (ajax) {
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

        Integer accountId = null;
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String invalidCredentialsMsg = "Incorrect username/password combination. Please try again.";
        String redirectUrl = req.getContextPath() + "/profile";

        System.out.println("Login attempt from user " + username + "Password: " + password);

        Map<String, String> data = new HashMap<>();
        resp.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8");


        // Println statements to show whether or not AJAX is working
        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
        if (ajax) {
            System.out.println("Ajax request on LoginServlet doPost");

        } else {
            System.out.println("doPost on LoginServlet, not Ajax");
        }

        try {
            accountId =  controller.logIn(username, password);
        } catch(DataIntegrityViolationException e) {
            // TODO: Redirect to failure page
            //resp.sendError(500, "Welp, something went wrong :(");
            System.out.println(e.getCause() + "More than one account with specified username and password");
        }


        if(accountId != null) {
            HttpSession session = req.getSession(true);
            session.setAttribute("accountId", accountId);
            data.put("redirect", redirectUrl);
        }
        else {
            data.put("messageerror", invalidCredentialsMsg);
        }

        String json = new Gson().toJson(data);
        System.out.println(json);
        resp.getWriter().write(json);

    }

}
