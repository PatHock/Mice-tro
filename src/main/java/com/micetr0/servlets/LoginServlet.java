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
    // FIXME: a lot of this code should be handled in the Account controller. Also, do not create models...
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

//        //FIXME: BAD
//        Account model = new Account();

        AccountController controller = new AccountController();

//        // FIXME: remove this, remove method setModel from account controller
//        controller.setModel(model);

        String failedLoginError = null;
        String tried = "false";
        String correctLogin = null;

        try{
            //get username and password from entered data
            String curUsername = getString(req, "username");
            String curPassword = getString(req, "password");
            System.out.println(curUsername);
            System.out.println(curPassword);

//            //set password and username
//            model.setUsername(curUsername);
//            model.setPassword(curPassword);


            //List<Account> accountsList= new ArrayList<>();

//            // FIXME: This should be taken care of in the Account controller
//            List<Account> accountsList = controller.getAllAccounts();
            //Account tempAccount = new Account();
            //tempAccount.setUsername("aredhouse");
            //tempAccount.setPassword("pass");
            //accountsList.add(tempAccount);


            //FIXME: don't create models anywhere except in controller class
            Account validAccount = controller.logIn(curUsername, curPassword, accountsList);

            //FIXME: Account controller should be able to tell the servlet if the specified account is valid
            //
            if (validAccount != null){
                tried = "true";
                correctLogin = "You have successfully logged in, Click below to go to Profile";
                //resp.sendRedirect("profile.jsp");
                //System.out.println(validAccount);
            }
            else{
                //resp.sendRedirect("Login.jsp");
                failedLoginError = "Username and Password Combination Invalid";
            }
        }
       catch(InvalidParameterException e){

        }

        req.setAttribute("login", model);
        req.setAttribute("failedLoginError", failedLoginError);
        req.setAttribute("tried", tried);
        req.setAttribute("correctLogin", correctLogin);


        if(tried == "true"){
            req.getRequestDispatcher("/profile.jsp").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("/Login.jsp").forward(req, resp);
        }

    }

    private String getString(HttpServletRequest req, String name) {
        return req.getParameter(name);
    }


}
