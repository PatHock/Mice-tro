package com.micetr0.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name="ErrorServlet",
        urlPatterns = "/whoops",
        description = "Error page",
        loadOnStartup = 1
)
public class ErrorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                throws ServletException, IOException {

            req.getRequestDispatcher("/whoops.jsp").forward(req, resp);

        }



}
