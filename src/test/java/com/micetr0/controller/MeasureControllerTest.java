package com.micetr0.controller;

import com.micetr0.model.Measure;
import com.micetr0.model.Note;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class MeasureControllerTest {
    private MeasureController controller;
    private Measure model;

    @Before
    public void setUp()
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
