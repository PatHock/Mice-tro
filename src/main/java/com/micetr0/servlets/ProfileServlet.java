package com.micetr0.servlets;

import com.micetr0.model.Composition;
import com.micetr0.controller.CompositionController;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(
        name = "ProfileServlet",
        urlPatterns = {"/profile"},
        description = "Whatever this servlet does, describe here",
        loadOnStartup = 1
)
public class ProfileServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Profile Servlet: doGet");

        req.getRequestDispatcher("/profile.jsp").forward(req, resp);

        //LogOut user
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Composition model = new Composition();

        CompositionController controller = new CompositionController();


        //Get current user information from login
        String currUser = "aredhouse";

        //Use current user name to get a list of compositions and extract their names to display
        //Need get compositions method for input username
        List<Composition> currCompList= new ArrayList<>();

        Composition tempComp1 = new Composition();
        tempComp1.setYear(1234);
        tempComp1.setTitle("Composition A");
        tempComp1.setCompositionID(1);
        tempComp1.setDesc("Test Comp 1");
        currCompList.add(tempComp1);

        Composition tempComp2 = new Composition();
        tempComp1.setYear(5678);
        tempComp1.setTitle("Composition B");
        tempComp1.setCompositionID(2);
        tempComp1.setDesc("Test Comp 2");
        currCompList.add(tempComp1);

        List<String> compNames = new ArrayList<>();

        for (Composition comp : currCompList){
            compNames.add(comp.getTitle());
        }

        req.setAttribute("comp", model);
        req.setAttribute("currUser", currUser);
        req.setAttribute("compNames", compNames);





    }
}