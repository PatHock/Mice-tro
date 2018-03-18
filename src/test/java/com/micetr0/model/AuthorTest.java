package com.micetr0.model;

import com.micetr0.controller.AccountController;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class AuthorTest {
    private Account model;
    @Before
    public void setUp()
    {
        model = new Account();
    }

    @Test
    public void getPasswordTest() {
        model.setPassword("pASSword");
        assertTrue(model.getPassword().equals("pASSword"));
    }

    @Test
    public void setPasswordTest(){
        model.setPassword("pASSword");
        assertTrue(model.getPassword().equals("pASSword"));
    }

    @Test
    public void getUsernameTest() {
        model.setUsername("Drop Table Accounts");
        assertTrue(model.getUsername().equals("Drop Table Accounts"));
    }

    @Test
    public void setUsernameTest() {
        model.setUsername("Drop Table Accounts");
        assertTrue(model.getUsername().equals("Drop Table Accounts"));
    }

    @Test
    public void getViewableComps(){
        List<Object> comps = new ArrayList<>();
        comps.add("comp1");
        model.setViewableComps(comps);
        assertTrue(model.getViewableComps().get(0).equals("comp1"));
    }
    @Test
    public void setViewableComps(){
        List<Object> comps = new ArrayList<>();
        comps.add(1);
        comps.add(2);
        comps.add(3);
        model.setViewableComps(comps);
        assertTrue(model.getViewableComps().size() == 3);

    }
    @Test
    public void setEditableComps(){
        List<Object> comps = new ArrayList<>();
        comps.add("comp1");
        model.setViewableComps(comps);
        assertTrue(model.getViewableComps().get(0).equals("comp1"));

    }
    @Test
    public void getEditableComps(){
        List<Object> comps = new ArrayList<>();
        comps.add(1);
        comps.add(2);
        comps.add(3);
        model.setEditableComps(comps);
        assertTrue(model.getEditableComps().size() == 3);
    }

}