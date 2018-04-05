package com.micetr0.model;

import org.junit.Test;
import com.micetr0.model.Note;

import static org.junit.Assert.*;

public class MeasureTest {
//    private Note note = new Note();
    private Measure measure = new Measure();

    @Test
    public void getMaxNumBeatsTest(){
        measure.setMaxNumBeats(50);
        assertTrue(measure.getMaxNumBeats().equals(50));
    }

    @Test
    public void setMaxNumBeatsTest(){
        measure.setMaxNumBeats(10);
        assertTrue(measure.getMaxNumBeats().equals(10));
    }

    @Test
    public void getMeasureIDTest(){
        measure.setMeasureID("12");
        assertEquals(measure.getMeasureID(),"12");
    }

    @Test
    public void setMeasureIDTest(){
        measure.setMeasureID("15");
        assertEquals(measure.getMeasureID(),"15");
    }

    @Test
    public void getSectionIDTest(){
        measure.setSectionID("3");
        assertEquals(measure.getSectionID(),"3");
    }

    @Test
    public void setSectionIDTest(){
        measure.setSectionID("5");
        assertEquals(measure.getSectionID(),"5");
    }

}