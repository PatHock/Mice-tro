package com.micetr0.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
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
import java.util.HashMap;
import java.util.Map;

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

        HttpSession session = req.getSession();
        Integer accountId = null;
        String redirectUrl = req.getContextPath() + "/composition";
        CompositionController controller = new CompositionController();
        Composition composition = null;
        String abcString;
        Integer compId = null;
        AbcTranslator translator = new AbcTranslator();
        Map<String, String> data = new HashMap<>();
        resp.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8");

        if(session != null) {
            accountId = (Integer) session.getAttribute("accountId");
            if (accountId == null) {
                resp.sendRedirect("/login");
            }
        }


        // Println statements to show whether or not AJAX is working
        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
        if (ajax) {
            System.out.println("Ajax doGet on CompositionServlet");
            if (req.getParameter("compId") != null) {
                compId = Integer.parseInt(req.getParameter("compId"));
                composition = controller.getCompositionByCompositionId(compId);
                if (composition != null) {
                    abcString = translator.abcBuilder(composition);
                    data.put("abcString", abcString);
                    data.put("redirect", redirectUrl);
                    String json = new Gson().toJson(data);
                    System.out.println(json);
                    resp.getWriter().write(json);
                }
            }
        } else {
            System.out.println("doGet on CompositionServlet");
            req.getRequestDispatcher("/composition.jsp").forward(req, resp);
        }
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

        CompositionController controller = new CompositionController();
        Composition composition = new Composition();

        HttpSession session = req.getSession();
        Integer accountId = null;
        resp.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8");
        String abcString;

        if (session!=null) {
            accountId = (Integer) session.getAttribute("accountId");
        }

        if(accountId == null){
            resp.sendRedirect(req.getContextPath() + "/login");
        } else {
            //TODO: add
//            abcString = translator.abcBuilder(controller.getCompositionsByAccountId(accountId).get(0));
//            System.out.println("ABC format for composition 0 is: " + abcString);
        }
    }
}
