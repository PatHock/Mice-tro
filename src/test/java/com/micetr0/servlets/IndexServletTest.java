package com.micetr0.servlets;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
class IndexServletTest {
    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private RequestDispatcher requestDispatcher;

    @BeforeAll
    void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doGet() {
        when(request.getRequestDispatcher("/index.jsp")).thenReturn(requestDispatcher);

        //TODO: Handle these exceptions elsewhere, by redirecting to an error page etc
        try {
            new IndexServlet().doGet(request, response);
            verify(requestDispatcher).forward(request, response);

        } catch(ServletException e) {
            fail("Servlet Exception thrown", e.getCause());
            e.printStackTrace();
        } catch (IOException e) {
            fail("IO Exception thrown", e.getCause());
            e.printStackTrace();
        }
    }
}