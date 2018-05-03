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

        Account model = new Account();

        AccountController controller = new AccountController();

        //FIXME commented out
//        controller.setModel(model);

        String failedLoginError = null;
        String tried = "false";
        String failedCreation = null;
        String usernameAlreadyExisits = null;
        Boolean newUsername = false;


        try{
            //get username and password from entered data
            String curUsername = getString(req, "username");
            String curPassword = getString(req, "password");

            System.out.println(curUsername);
            System.out.println(curPassword);

            //set password and username
            model.setUsername(curUsername);
            model.setPassword(curPassword);

            Account newAccount = new Account();
            newAccount = controller.createAccount(curUsername, curPassword);

            //check to see if username already exists
            newUsername = controller.checkNewAccount(curUsername);

            //if username does not already exit, add to database if also over length requirement
            if(newUsername == true && curUsername.length() > 4 && curPassword.length() > 4){
                controller.addAccount(newAccount);
            }

            else if (curUsername.length() < 4  || curPassword.length() < 4) {
                failedCreation = "Please Enter a valid username and password longer than 3 characters";
            }

            else if(newUsername == false){
                failedCreation = "Username already exists, please try again";
            }
        }
        catch(InvalidParameterException e){

        }

        req.setAttribute("createAcc", model);
        req.setAttribute("failedLoginError", failedLoginError);
        req.setAttribute("tried", tried);
        req.setAttribute("failedCreation", failedCreation);

        if(failedCreation == null){
            req.getRequestDispatcher("/profile.jsp").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("/createAccount.jsp").forward(req, resp);
        }


    }

    private String getString(HttpServletRequest req, String name) {
        return req.getParameter(name);
    }



}
