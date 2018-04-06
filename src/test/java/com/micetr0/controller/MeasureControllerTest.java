package com.micetr0.controller;

import com.micetr0.model.Measure;

import org.junit.jupiter.api.BeforeEach;

public class MeasureControllerTest {
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
    public void createMeasureTest(){
        Measure testMeasure = controller.createMeasure(50,"1","2");
        assertTrue(testMeasure.getMaxNumBeats().equals(50));
        assertTrue(testMeasure.getMeasureID().equals("1"));
        assertTrue(testMeasure.getSectionID().equals("2"));
    }

    @Test
    public void deleteMeasureTest(){
        //fix after implementing delete measure
        boolean result;
        result = controller.deleteMeasure();
        assertFalse(result);
    }

    @Test
    public void addMeasureTest(){
        //add after implementing add measure
    }

}
