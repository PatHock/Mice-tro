package com.micetr0.controller;

import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.Mock_DB;
import com.micetr0.model.Measure;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MeasureControllerTest {


    @BeforeEach
    void setUp()
    {
        DatabaseProvider.setInstance(new Mock_DB());
        MeasureController controller = new MeasureController();
    }

    @Test
    void createMeasureTest(){
        //TODO: Implement
    }

    @Test
    void deleteMeasureTest(){
        //TODO: Implement
    }


}
