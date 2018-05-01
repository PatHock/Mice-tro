package com.micetr0.listener;


// https://www.javatpoint.com/HttpSessionEvent

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class CountUserListener implements HttpSessionListener{

    private ServletContext servletContext = null;
    private Integer totalSessionCount = 0;
    private Integer currentSessionCount = 0;

    /**
     *
     * @param se HTTP session event for when a user logs into the website
     */
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        totalSessionCount++;
        currentSessionCount++;

        servletContext=se.getSession().getServletContext();
        servletContext.setAttribute("totalUsers", totalSessionCount);
        servletContext.setAttribute("currentUsers", currentSessionCount);

        HttpSession session = se.getSession();
        session.setAttribute("numUsersOnline", currentSessionCount);
        System.out.println("Session created, " + currentSessionCount + "users online");
    }

    /**
     *
     * @param se HTTP session event for when a user logs out of the website
     */
    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        currentSessionCount--;
        servletContext.setAttribute("currentUsers",currentSessionCount);
    }



}
