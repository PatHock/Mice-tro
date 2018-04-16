package com.micetr0.controller;

import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.mock_DB.Mock_DB;
import com.micetr0.model.Composition;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class CompositionControllerTest {

    private Composition model;
    private CompositionController controller;
    private IDatabase db;


    @BeforeEach
    void setUp(){
        model = new Composition();
        DatabaseProvider.setInstance(new Mock_DB());
        controller = new CompositionController();
        controller.setModel(model);
        db = DatabaseProvider.getInstance();
    }

    @Test
    void changeTitleTest()
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
    void changeYearTest()
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