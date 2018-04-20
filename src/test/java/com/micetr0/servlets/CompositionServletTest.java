package com.micetr0.servlets;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CompositionServletTest {
    @Mock private HttpServletRequest request;
    @Mock private HttpServletResponse response;
    @Mock private RequestDispatcher requestDispatcher;


    @BeforeAll
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);
    }

    @Test
    void doGet() throws Exception {
        when(request.getRequestDispatcher("/composition.jsp")).thenReturn(requestDispatcher);
        new CompositionServlet().doGet(request, response);
        verify(requestDispatcher).forward(request, response);
    }
}