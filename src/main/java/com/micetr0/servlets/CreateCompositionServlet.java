package com.micetr0.servlets;

import com.google.gson.Gson;
import com.micetr0.model.Composition;
import com.micetr0.controller.CompositionController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.HashMap;
import java.util.Map;


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
        Integer accountId = null;
        CompositionController controller = new CompositionController();
        String redirectUrl = req.getContextPath() + "/profile";
        Map<String, String> data = new HashMap<>();

        resp.setContentType("application/json");  // Set content type of the response so that jQuery knows what it can expect.
        resp.setCharacterEncoding("UTF-8");

        boolean ajax = "XMLHttpRequest".equals(req.getHeader("X-Requested-With"));
        if (ajax) {
            System.out.println("Ajax request on CreateCompositionServlet doPost");

        } else {
            System.out.println("doPost on CreateCompositionServlet, not Ajax");
        }

        HttpSession session = req.getSession();

        if (session!=null) {
            accountId = (Integer) session.getAttribute("accountId");
        }

        if(accountId == null){
            resp.sendRedirect(req.getContextPath() + "/login");
        }
        else {
            //TODO: add error response here
            Composition comp = controller.createComposition(accountId);
            if(!req.getParameter("year").isEmpty()) {
                try {
                    controller.updateYear(comp, Integer.parseInt(req.getParameter("year")));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }

            controller.updateDescription(comp, req.getParameter("description"));
            controller.updateTitle(comp, req.getParameter("title"));

            data.put("redirect", redirectUrl);
        }

        String json = new Gson().toJson(data);
        System.out.println(json);
        resp.getWriter().write(json);

    }

}
