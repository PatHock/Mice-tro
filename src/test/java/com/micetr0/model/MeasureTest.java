package com.micetr0.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MeasureTest {

    private Integer measureID;
    private Integer sectionID;
    private Measure measure;

    @BeforeEach
    void setUp() {
        sectionID = 0;
        measureID = 0;
        measure = new Measure(measureID, sectionID);
    }

    @Test
    void setMeasureIDTest(){
        measure.setMeasureID(248);
        assertTrue(measure.getMeasureID().equals(248));

        measure.setMeasureID(9);
        assertTrue(measure.getMeasureID().equals(9));
    }

    @Test
    void setSectionIDTest(){
        measure.setSectionID(248);
        assertTrue(measure.getSectionID().equals(248));

        measure.setSectionID(9);
        assertTrue(measure.getSectionID().equals(9));
    }

}