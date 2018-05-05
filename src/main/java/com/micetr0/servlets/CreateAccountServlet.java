package com.micetr0.servlets;

import com.micetr0.controller.AccountController;
import com.micetr0.model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

@WebServlet (
        name = "CreateAccountServlet",
        urlPatterns = {"/createAccount"},
        description = "Creates Accounts",
        loadOnStartup = 1
)
public class CreateAccountServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Create Account Servlet: doGet");

        req.getRequestDispatcher("/createAccount.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        AccountController controller = new AccountController();









//        try{
//            //get username and password from entered data
//            String curUsername = getString(req, "username");
//            String curPassword = getString(req, "password");
//
//            if (curUsername.length() < 4  || curPassword.length() < 4) {
//                failedCreation = "Please Enter a valid username and password";
//                //resp.sendRedirect("profile.jsp");
//                //System.out.println(validAccount);
//            }
//            else{
//                //resp.sendRedirect("login.jsp");
//                tried = "true";
//            }
//        }
//        catch(InvalidParameterException e){
//
//        }
//
//        req.setAttribute("createAcc", model);
//        req.setAttribute("failedLoginError", failedLoginError);
//        req.setAttribute("tried", tried);
//        req.setAttribute("failedCreation", failedCreation);
//
//        if(failedCreation == null){
//            req.getRequestDispatcher("/profile.jsp").forward(req, resp);
//        }
//        else{
//            req.getRequestDispatcher("/createAccount.jsp").forward(req, resp);
//        }


    }
}
