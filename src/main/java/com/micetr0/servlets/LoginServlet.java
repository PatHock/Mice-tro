package com.micetr0.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import com.micetr0.controller.AccountController;
import com.micetr0.model.Account;
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

        req.getRequestDispatcher("/Login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        AccountController controller = new AccountController();

        Boolean isValidCredentials = false;

        //TODO: get rid of these
//        String correctLogin;
        String failedLoginError;



            //get username and password from entered data
//            String username = getString(req, "username");
//            String password = getString(req, "password");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            System.out.println(username);
            System.out.println(password);

            try {
                isValidCredentials =  controller.logIn(username, password);
            } catch(DataIntegrityViolationException e) {
                // TODO: Redirect to failure page
                System.out.println(e.getCause() + "More than one account with specified username and password");
            }



//            if(isValidCredentials){
//                correctLogin = "You have successfully logged in, Click below to go to Profile";
//            }
//            else {
//                failedLoginError = "Username and Password Combination Invalid";
//            }

            if(isValidCredentials) {
                req.getRequestDispatcher("/profile.jsp").forward(req, resp);
            }
            else {
                failedLoginError = "Username and Password Combination Invalid";
                req.getRequestDispatcher("/Login.jsp").forward(req, resp);
            }


//            req.setAttribute("login", model);
//        req.setAttribute("failedLoginError", failedLoginError);
//        req.setAttribute("tried", tried);
//        req.setAttribute("correctLogin", correctLogin);


    }

}
