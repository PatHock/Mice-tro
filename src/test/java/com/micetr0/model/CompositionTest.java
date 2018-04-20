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
        assertEquals(title, composition.getTitle());
    }

    @Test
    void setTitleTest() {
        String title = "Sixth Symphony";
        composition.setTitle(title);
        assertEquals(title, composition.getTitle());
    }

    @Test
    void setYearTest(){
        Integer year = 1996;
        composition.setYear(year);

        assertEquals(year, composition.getYear());
    }

    @Test
    void getYearTest()
    {
        Integer year = 1996;
        composition.setYear(year);

        assertEquals(year, composition.getYear());
    }

    @Test
    void setIsViewablePubliclyTest() {
        Integer isViewablePublicly;

        assertNull(composition.getIsViewablePublicly());

        isViewablePublicly = 0;
        composition.setIsViewablePublicly(isViewablePublicly);
        assertEquals(isViewablePublicly, composition.getIsViewablePublicly());

        isViewablePublicly = 1;
        composition.setIsViewablePublicly(isViewablePublicly);
        assertEquals(isViewablePublicly, composition.getIsViewablePublicly());

    }

    @Test
    void setAccountIdTest() {
        Integer accountId;

        assertNull(composition.getCompositionID());

        accountId = 24753451;
        composition.setAccountId(accountId);
        assertEquals(accountId, composition.getAccountId());

        accountId = 0;
        composition.setAccountId(accountId);
        assertEquals(accountId, composition.getAccountId());

    }
}
