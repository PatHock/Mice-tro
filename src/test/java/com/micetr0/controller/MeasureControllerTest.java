package com.micetr0.controller;

import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.Mock_DB;
import com.micetr0.model.Measure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MeasureControllerTest {

    MeasureController controller;

    @BeforeEach
    void setUp()
    {
        DatabaseProvider.setInstance(new Mock_DB());
        controller = new MeasureController();
    }

    @Test
    void createMeasureTest(){
        assertNotNull(controller.createMeasure(1));
    }

    /*
    @Test
    void deleteMeasureTest(){
        controller.insertMeasure(1);
        assertTrue(controller.deleteMeasure(1));
    }
*/

}
