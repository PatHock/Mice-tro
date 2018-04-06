package com.micetr0.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

class MeasureTest {
//    private Note note = new Note();
    private Measure measure = new Measure();

    @Test
    void getMaxNumBeatsTest(){
        measure.setMaxNumBeats(50);
        assertTrue(measure.getMaxNumBeats().equals(50));
    }

    @Test
    void setMaxNumBeatsTest(){
        measure.setMaxNumBeats(10);
        assertTrue(measure.getMaxNumBeats().equals(10));
    }

    @Test
    void getMeasureIDTest(){
        measure.setMeasureID("12");
        assertEquals(measure.getMeasureID(),"12");
    }

    @Test
    void setMeasureIDTest(){
        measure.setMeasureID("15");
        assertEquals(measure.getMeasureID(),"15");
    }

    @Test
    void getSectionIDTest(){
        measure.setSectionID("3");
        assertEquals(measure.getSectionID(),"3");
    }

    @Test
    void setSectionIDTest(){
        measure.setSectionID("5");
        assertEquals(measure.getSectionID(),"5");
    }

}