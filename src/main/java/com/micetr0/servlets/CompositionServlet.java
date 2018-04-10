package com.micetr0.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

}
