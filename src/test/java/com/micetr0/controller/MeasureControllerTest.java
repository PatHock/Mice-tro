package com.micetr0.controller;

import com.micetr0.model.Measure;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MeasureControllerTest {
    private MeasureController controller;
    private Measure model;

    @BeforeEach
    void setUp()
    {
        model = new Measure();
        controller = new MeasureController();
        controller.setModel(model);
    }

    @Test
    void createMeasureTest(){
        Measure testMeasure = controller.createMeasure(50,"1","2");
        assertTrue(testMeasure.getMaxNumBeats().equals(50));
        assertTrue(testMeasure.getMeasureID().equals("1"));
        assertTrue(testMeasure.getSectionID().equals("2"));
    }

    @Test
    void deleteMeasureTest(){
        //fix after implementing delete measure
        boolean result;
        result = controller.deleteMeasure();
        assertFalse(result);
    }

    @Test
    void addMeasureTest(){
        //add after implementing add measure
    }

}
