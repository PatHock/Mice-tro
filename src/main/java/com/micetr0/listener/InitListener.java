package com.micetr0.listener;

import com.micetr0.mock_DB.InitDatabase;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Scanner;

@javax.servlet.annotation.WebListener
    public class InitListener implements ServletContextListener {
        @Override
        public void contextInitialized(ServletContextEvent sce) {
            // Initialize the database

            try {
                InitDatabase.init(true);
            } catch (UnsupportedOperationException e) {
                System.out.println("UnsupportedOperationException: " + e.getMessage());
            }

            System.out.println("Database initialized successfully.");

        }

        @Override
        public void contextDestroyed(ServletContextEvent sce) {
            System.out.println("Micetr0 has been destroyed :(");
        }

    }
