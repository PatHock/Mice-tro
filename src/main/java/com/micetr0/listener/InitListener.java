package com.micetr0.listener;
import com.micetr0.mock_DB.InitDatabase;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@javax.servlet.annotation.WebListener
    public class InitListener implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent sce) {
            ServletContext sc = sce.getServletContext();
//            String path = sc.getInitParameter("path");
//            String mode = sc.getInitParameter("mode");
//            sc.setAttribute("filePath", path);
//            sc.setAttribute("fileMode", mode);
            InitDatabase.init(true);
            System.out.println("Fake Database initialized.");
        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            ServletContext sc = sce.getServletContext();
//            sc.removeAttribute("path");
//            sc.removeAttribute("mode");
//            System.out.println("Value deleted from context.");
        }
    }
