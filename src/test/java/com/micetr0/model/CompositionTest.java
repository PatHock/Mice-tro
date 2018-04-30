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

    @Test
    void setAccountIDTest()
    {
        Integer accountID = 30;
        composition.setAccountId(accountID);

        assertTrue(composition.getAccountId() == 30);
    }

    @Test
    void getAccountIDTest()
    {
        Integer accountID = 1;
        composition.setAccountId(accountID);

        assertTrue(composition.getAccountId() == 1);
    }

    @Test
    void getIsViewablePubliclyTest()
    {
        Integer viewable = 0;
        composition.setIsViewablePublicly(viewable);

        assertTrue(composition.getIsViewablePublicly() == 0);
    }

    @Test
    void setCompositionIDTest(){
        composition.setCompositionID(4);

        assertTrue(composition.getCompositionID() == 4);
    }

    @Test
    void getCompositionIDTest(){
        composition.setCompositionID(10);

        assertTrue(composition.getCompositionID() == 10);
    }
}
