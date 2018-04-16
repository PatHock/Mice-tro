package com.micetr0.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class AuthorTest {
    private Account model;
    @BeforeEach
    void setUp()
    {
        model = new Account();
    }

    @Test
    void getPasswordTest() {
        model.setPassword("pASSword");
        assertTrue(model.getPassword().equals("pASSword"));
    }

    @Test
    void setPasswordTest(){
        model.setPassword("pASSword");
        assertTrue(model.getPassword().equals("pASSword"));
    }

    @Test
    void getUsernameTest() {
        model.setUsername("Drop Table Accounts");
        assertTrue(model.getUsername().equals("Drop Table Accounts"));
    }

    @Test
    void setUsernameTest() {
        model.setUsername("Drop Table Accounts");
        assertTrue(model.getUsername().equals("Drop Table Accounts"));
    }

    @Test
    void getViewableComps(){
        List<String> comps = new ArrayList<>();
        comps.add("comp1");
        model.setViewableComps(comps);
        assertTrue(model.getViewableComps().get(0).equals("comp1"));
    }
    @Test
    void setViewableComps(){
        List<String> comps = new ArrayList<>();
        comps.add("1");
        comps.add("2");
        comps.add("3");
        model.setViewableComps(comps);
        assertTrue(model.getViewableComps().size() == 3);

    }
    @Test
    void setEditableComps(){
        List<String> comps = new ArrayList<>();
        comps.add("comp1");
        model.setViewableComps(comps);
        assertTrue(model.getViewableComps().get(0).equals("comp1"));

    }
    @Test
    void getEditableComps(){
        List<String> comps = new ArrayList<>();
        comps.add("1");
        comps.add("2");
        comps.add("3");
        model.setEditableComps(comps);
        assertTrue(model.getEditableComps().size() == 3);
    }

    @Test
    void setAuthorIDTest()
    {
        Integer authorID = 1;
        model.setAccountID(authorID);
        assertTrue(model.getAccountID().equals(authorID));
    }
}