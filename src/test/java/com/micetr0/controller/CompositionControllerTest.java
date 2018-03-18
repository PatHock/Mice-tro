package com.micetr0.controller;

import com.micetr0.model.Composition;
import com.micetr0.model.Section;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CompositionControllerTest {

    private Composition model;
    private CompositionController controller;

    @Before
    public void setUp(){
        model = new Composition();
        controller = new CompositionController();
        controller.setModel(model);
    }

    @Test
    public void changeTitleTest()
    {
        String title = "My first composition";
        controller.changeTitle(title);
        assertTrue(model.getTitle().equals(title));
        controller.changeTitle(title);
        assertTrue(model.getTitle().equals(title));
        title = "Title";
        controller.changeTitle(title);
        assertTrue(model.getTitle().equals(title));
    }

    @Test
    public void changeYearTest()
    {
        Integer year = 1996;
        controller.changeYear(year);
        assertTrue(model.getYear() == year);
        controller.changeYear(1996);
        assertTrue(model.getYear().equals(year));
        year = 2018;
        controller.changeYear(year);
        assertTrue(model.getYear() == year);
    }
}