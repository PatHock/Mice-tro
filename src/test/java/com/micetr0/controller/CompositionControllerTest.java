package com.micetr0.controller;

import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.mock_DB.Mock_DB;
import com.micetr0.model.Composition;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;

class CompositionControllerTest {

    private CompositionController controller;
    private IDatabase db;


    @BeforeEach
    void setUp(){
        DatabaseProvider.setInstance(new Mock_DB());
        controller = new CompositionController();
        db = DatabaseProvider.getInstance();
    }

//    @Test
//    void changeTitleTest()
//    {
//        String title = "My first composition";
//        controller.changeTitle(title);
//        assertTrue(model.getTitle().equals(title));
//        controller.changeTitle(title);
//        assertTrue(model.getTitle().equals(title));
//        title = "Title";
//        controller.changeTitle(title);
//        assertTrue(model.getTitle().equals(title));
//    }


    @Test
    void createCompositionTest() {
        //TODO: Add more testing here
        controller.createComposition();
    }

    @Test
    void updateTitleTest() {
        Composition compFergie = db.findCompositionsByCompositionId(4).get(0);
        String title;

        assertEquals("I Can't Think of Another Title", compFergie.getTitle());

        title = "Just another one of those random off-the-cuff test code variables :)";
        assertTrue(controller.updateTitle(compFergie, title));
        assertEquals(title, compFergie.getTitle());

    }

    @Test
    void updateYearTest() {
        Composition compFergie;
        Integer year;

        assertEquals(1, db.findCompositionsByCompositionId(4).size());
        compFergie = db.findCompositionsByCompositionId(4).get(0);
        assertEquals((Integer) 2018, compFergie.getYear());

        //valid year, in the past
        year = 2008;
        assertTrue(controller.updateYear(compFergie, year));
        assertEquals(year, compFergie.getYear());
        assertEquals(year, db.findCompositionsByCompositionId(compFergie.getCompositionID()).get(0).getYear());

        // invalid year, hopefully in the future when reading this
        year = 2100;
        assertFalse(controller.updateYear(compFergie, year));
        assertEquals((Integer) 2008, compFergie.getYear());
        assertEquals((Integer) 2008, db.findCompositionsByCompositionId(compFergie.getCompositionID()).get(0).getYear());
    }

    @Test
    void updateDescriptionTest() {
        List<Composition> compositionList;

        Composition compFergie = db.findCompositionsByCompositionId(4).get(0);
//        compFergie.setTitle("I Can't Think of Another Title");
//        compFergie.setYear(2018);
//        compFergie.setDesc("Deffinicious");
//        compFergie.setCompositionID(4);

        String description = "1234567890~`!@#$%^&*()_+-=qwertyuiopasdfghjklzxcvbnm[]{}";

        compositionList = db.findCompositionsByCompositionId(4);

        assertEquals(1, compositionList.size());
        assertEquals(compositionList.get(0).getDesc(), compFergie.getDesc());


        assertTrue(controller.updateDescription(compFergie, description));
        assertEquals(description, compFergie.getDesc());

        compositionList = db.findCompositionsByCompositionId(4);
        assertEquals(1, compositionList.size());

        assertEquals(description, compositionList.get(0).getDesc());
    }


}