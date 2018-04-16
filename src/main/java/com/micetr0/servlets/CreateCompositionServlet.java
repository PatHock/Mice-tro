package com.micetr0.servlets;

import com.micetr0.model.Composition;
import com.micetr0.controller.CompositionController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidParameterException;


@WebServlet(
        name = "CreateCompositionServlet",
        urlPatterns = {"/createComposition"},
        description = "Whatever this servlet does, describe here",
        loadOnStartup = 1
)
public class CreateCompositionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Create Composition Servlet: doGet");

        req.getRequestDispatcher("/createComposition.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Composition model = new Composition();

        CompositionController controller = new CompositionController();

        controller.setModel(model);

        //boolean used to check if values entered are valid
        boolean valid = false;

        //error message for invalid user input
        String invalidInput = null;

        //non-numbers input in year field
        String invalidNum = null;

        try{
            //get data entered on page for new composition
            String title = getString(req,"title");
            String year = getString(req, "year");
            String desc = getString(req, "desc");

            System.out.println(title);
            System.out.println(year);

            model.setDesc(desc);
            model.setTitle(title);

            //check to see if year only contains numbers, if it does, add year to model
            if (year.matches("[0-9]+")) {
                Integer yearInt = Integer.parseInt(year);
                model.setYear(yearInt);
            }
            else{
                invalidNum = "Please only input numbers in YEAR COMPOSED field";
            }

            //check to see if info was entered, if not prompt user to enter all fields
            if((title.length() > 1) && (year.length() == 4) && (desc.length() > 1) && invalidNum == null){
                valid = true;
            }

            else{
                valid = false;
                invalidInput = "Please enter values for all fields";
            }

        }
        catch(InvalidParameterException e){

        }

        req.setAttribute("createC", model);
        req.setAttribute("invalidInput", invalidInput);
        req.setAttribute("valid", valid);
        req.setAttribute("invalidNum", invalidNum);


        if (valid == true){
            req.getRequestDispatcher("/composition.jsp").forward(req, resp);
        }
        else{
            req.getRequestDispatcher("/createComposition.jsp").forward(req, resp);
        }

    }

    private String getString(HttpServletRequest req, String name) {
        return req.getParameter(name);
    }

}
