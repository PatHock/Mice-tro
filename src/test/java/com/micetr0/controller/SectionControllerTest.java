package com.micetr0.controller;

import com.micetr0.definitions.Defs;
import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.mock_DB.Mock_DB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SectionControllerTest {
    private SectionController controller;
    private IDatabase db;

    @BeforeEach
    void createModel(){
        DatabaseProvider.setInstance(new Mock_DB());
        controller = new SectionController();
        db = DatabaseProvider.getInstance();
    }

    @Test
    void createSectionControllerTest(){
        assertNotNull(controller.createSection(120, Defs.Key.C_MAJOR,Defs.Clef.TREBLE,Defs.TimeSignature.EIGHT_SIXTEEN,2,5));
    }

    @Test
    void addDBSection(){
        controller.createSection(120, Defs.Key.C_MAJOR,Defs.Clef.TREBLE,Defs.TimeSignature.EIGHT_SIXTEEN,2,5);
        assertNotNull(controller.findSection(5));
    }
}
