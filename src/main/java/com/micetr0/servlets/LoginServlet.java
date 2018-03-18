package com.micetr0.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//import com.micetr0.controller.AccountController;
//import com.micetr0.controller.Account;

public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Login Servlet: doGet");

        req.getRequestDispatcher("/Login.jsp").forward(req, resp);
    }
    /*@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Account model = new Account();

        AccountController controller = new AccountController();

        controller.setModel(model);

        String failedLoginError = null;

        //get username and password from entered data
        String curUsername = getString(req, "usrnm");
        String curPassword = getString(req, "psw");

        //set password and username
        model.setUsername(curUsername);
        model.setPassword(curPassword);

        List<Account> accountsList= new ArrayList<Account>;
        Account tempAccount = new Account();
        tempAccount.setUsername(aredhouse);
        tempAccount.setPassword(pass);
        accountsList.add(tempAccount);


        boolean validAccount = controller.checkCredentials(curUsername, curPassword, accountsList);

        if (validAccount == true){
            resp.sendRedirect("profile.jsp"); //correct login information
        }
        else{
            resp.sendRedirect("login.jsp");
            failedLoginError = "Username and Password Combination Invalid";
        }

        req.setAttribute("login", model);
    }

    private String getString(HttpServletRequest req, String name) {
        return req.getParameter(name);
    }*/


}
