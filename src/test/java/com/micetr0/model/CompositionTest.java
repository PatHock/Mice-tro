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
    public void getModeTest()
    {
        composition.setMode(Composition.Mode.edit);
        Composition.Mode mode = composition.getMode();
        assertTrue(mode.equals(Composition.Mode.edit));
    }

    @Test
    public void setMode() {
        composition.setMode(Composition.Mode.play);
        Composition.Mode mode = Composition.Mode.play;
        assertTrue(mode.equals(composition.getMode()));
    }

    @Test
    public void getUser(){
        Account account = new Account();
        account.setUsername("Pat Sucks");
        account.setPassword("loljk");
        composition.setUser(account.getUsername());
        assertTrue(composition.getUser().equals("Pat Sucks"));
    }
    @Test
    public void setUser(){
        Account account = new Account();
        account.setUsername("My Milkshakes");
        account.setPassword("Bring all the boys");
        composition.setUser(account.getUsername());
        assertTrue(composition.getUser().equals("My Milkshakes"));
    }

    @Test
    public void getTitle() {
        String title = "Sixth Symphony";
        composition.setTitle(title);
        assertTrue(composition.getTitle().equals(title));
    }

    @Test
    public void setTitle() {
        String title = "Sixth Symphony";
        composition.setTitle(title);
        assertTrue(composition.getTitle().equals(title));
    }

    @Test
    public void setSections() {
        throw new UnsupportedOperationException();
    }

    @Test
    public void getSections() {
        throw new UnsupportedOperationException();
    }

    @Test
    public void getViewer(){
        composition.setViewer("viewer");
        assertTrue(composition.getViewer().equals("viewer"));
    }

    @Test
    public void setViewer() {
        composition.setViewer("viewer");
        assertTrue(composition.getViewer().equals("viewer"));
    }



}
