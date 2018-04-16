package com.micetr0.servlets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ProfileServletTest {
    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private RequestDispatcher requestDispatcher;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doGet() {
        when(request.getRequestDispatcher("/profile.jsp")).thenReturn(requestDispatcher);

        //TODO: Handle these exceptions elsewhere, by redirecting to an error page etc
        try{
            new ProfileServlet().doGet(request, response);
            verify(requestDispatcher).forward(request, response);
        } catch(ServletException e) {
            fail("Servlet Exception thrown", e.getCause());
            e.printStackTrace();
        } catch (IOException e) {
            fail("IO Exception thrown", e.getCause());
            e.printStackTrace();
        }
    }

    @Test
    void doPost() {
        //FIXME: Implement tests
    }
}