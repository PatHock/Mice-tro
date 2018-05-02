package com.micetr0.servlets;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.micetr0.controller.CompositionController;
import com.micetr0.model.Composition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
        HttpSession session = req.getSession();
        Integer accountId = null;
        CompositionController controller = new CompositionController();
        List<Composition> compositionList = new ArrayList<>();
        String redirectUrl = req.getContextPath() + "/profile";

        resp.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8");


        if (session!=null) {
            accountId = (Integer) session.getAttribute("accountId");
        }

        if(accountId == null){
            resp.sendRedirect(req.getContextPath() + "/login");
        }
        else {
            System.out.println("User with account ID " + accountId + " Is logged in");
            // TODO: get all compositions
            req.getRequestDispatcher("/profile.jsp").forward(req, resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Integer accountId = null;
        CompositionController controller = new CompositionController();
        List<Composition> compositionList;
//        String redirectUrl = req.getContextPath() + "/profile";

        resp.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8");
        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));

        if (ajax) {
            System.out.println("Ajax request on ProfileServlet doPost");

        } else {
            System.out.println("doPost on ProfileServlet, not Ajax");
        }

        HttpSession session = req.getSession();

        if (session!=null) {
            accountId = (Integer) session.getAttribute("accountId");
        }

        if(accountId == null){
            resp.sendRedirect(req.getContextPath() + "/login");
        }
        else {
            compositionList = controller.getCompositionsByAccountId(accountId);

            String json = new Gson().toJson(compositionList);
            System.out.println(json);
            resp.getWriter().write(json);
        }

    }
}