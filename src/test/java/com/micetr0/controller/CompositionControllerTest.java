package com.micetr0.controller;

import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.mock_DB.Mock_DB;
import com.micetr0.model.Composition;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

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
        assertEquals(model.getYear(), year);

        year = 2018;
        controller.changeYear(year);
        assertEquals(model.getYear(), year);
    }

    @Test
    void updateDescriptionTest() {
        List<Composition> compositionList = new ArrayList<>();
        compositionList = db.findCompositionsByCompositionId(4);

        assertEquals(1, compositionList.size());
        assertEquals(compositionList.get(0).getDesc(), "Deffinicious");

        String description = "1234567890~`!@#$%^&*()_+-=qwertyuiopasdfghjklzxcvbnm[]{}";
        assertEquals(true, controller.updateDescription(4, description));


        compositionList = db.findCompositionsByCompositionId(4);
        assertEquals(1, compositionList.size());

        assertEquals(description, compositionList.get(0).getDesc());
    }


}