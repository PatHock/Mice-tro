package com.micetr0.servlets;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "IndexServlet",
        urlPatterns = {"/index"},
        description = "Whatever this servlet does, describe here",
        loadOnStartup = 1
)
public class IndexServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("Index Servlet: doGet");

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

}
