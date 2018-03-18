package com.micetr0.model;

import org.junit.Before;
import org.junit.Test;
import com.micetr0.model.Composition;
import org.junit.Before;
import org.junit.Test;
import com.micetr0.model.Section;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class CompositionTest {

    private Composition composition;

    @Before
    public void setUp()
    {
       composition = new Composition();
    }

    @Test
    public void getUserTest(){
        Account account = new Account();
        account.setUsername("Pat Sucks");
        account.setPassword("loljk");
        composition.setAuthor(account.getUsername());
        assertTrue(composition.getAuthor().equals("Pat Sucks"));
    }
    @Test
    public void setUserTest(){
        Account account = new Account();
        account.setUsername("My Milkshakes");
        account.setPassword("Bring all the boys");
        composition.setAuthor(account.getUsername());
        assertTrue(composition.getAuthor().equals("My Milkshakes"));
    }

    @Test
    public void getTitleTest() {
        String title = "Sixth Symphony";
        composition.setTitle(title);
        assertTrue(composition.getTitle().equals(title));
    }

    @Test
    public void setTitleTest() {
        String title = "Sixth Symphony";
        composition.setTitle(title);
        assertTrue(composition.getTitle().equals(title));
    }

    @Test
    public void setYearTest(){
        Integer year = 1996;
        composition.setYear(year);

        assertTrue(composition.getYear() == 1996);
    }

    @Test
    public void getYearTest()
    {
        Integer year = 1996;
        composition.setYear(year);

        assertTrue(composition.getYear() == 1996);
    }


}
