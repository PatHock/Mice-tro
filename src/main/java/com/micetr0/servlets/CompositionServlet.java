package com.micetr0.servlets;

import com.micetr0.AbcTranslator;
import com.micetr0.controller.CompositionController;
import com.micetr0.model.Composition;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (
        name = "CompositionServlet",
        urlPatterns = {"/composition"},
        description = "Whatever this servlet does, describe here",
        loadOnStartup = 1
)
public class CompositionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Composition Servlet: doGet");

        req.getRequestDispatcher("/composition.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Println statements to show whether or not AJAX is working
        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
        if (ajax) {
            System.out.println("Ajax doPost on CompositionServlet");
        } else {
            System.out.println("doPost on CompositionServlet");
        }

        CompositionController controller;
        Composition composition;
        AbcTranslator translator;
        HttpSession session = req.getSession();
        Integer accountId = null;
        resp.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8");

        if (session!=null) {
            accountId = (Integer) session.getAttribute("accountId");
        }

        if(accountId == null){
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            //TODO: add
        }
    }

}
