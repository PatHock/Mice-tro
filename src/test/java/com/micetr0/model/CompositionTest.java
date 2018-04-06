package com.micetr0.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CompositionTest {

    private Composition composition;

    @BeforeEach
    void setUp()
    {
       composition = new Composition();
    }

    @Test
    void getTitleTest() {
        String title = "Sixth Symphony";
        composition.setTitle(title);
        assertTrue(composition.getTitle().equals(title));
    }

    @Test
    void setTitleTest() {
        String title = "Sixth Symphony";
        composition.setTitle(title);
        assertTrue(composition.getTitle().equals(title));
    }

    @Test
    void setYearTest(){
        Integer year = 1996;
        composition.setYear(year);

        assertTrue(composition.getYear() == 1996);
    }

    @Test
    void getYearTest()
    {
        Integer year = 1996;
        composition.setYear(year);

        assertTrue(composition.getYear() == 1996);
    }
}
