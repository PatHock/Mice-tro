package com.micetr0.servlets;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
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

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreateAccountServletTest {
    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private RequestDispatcher requestDispatcher;

    @BeforeAll
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doGet() {
        when(request.getRequestDispatcher("/createAccount.jsp")).thenReturn(requestDispatcher);

        //TODO: Handle these exceptions elsewhere, by redirecting to an error page etc
        try {
            new CreateAccountServlet().doGet(request, response);
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
        //FIXME: Fix the create account servlet... and write unit tests here
    }
}