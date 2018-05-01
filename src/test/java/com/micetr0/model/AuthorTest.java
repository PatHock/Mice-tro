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
    void setEditableComps(){
        List<Composition> comps = new ArrayList<>();
        Composition composition = new Composition();
        composition.setCompositionID(1);
        comps.add(composition);
        model.setEditableComps(comps);
        assertTrue(model.getEditableComps().get(0).getCompositionID().equals(1));

    }
    @Test
    void getEditableComps(){
        List<Composition> comps = new ArrayList<>();
        Composition composition1 = new Composition();
        composition1.setCompositionID(1);
        composition1.setTitle("Composition Uno");
        Composition composition2 = new Composition();
        composition2.setCompositionID(2);
        composition2.setTitle("Compostiion dos");
        comps.add(composition1);
        comps.add(composition2);
        model.setEditableComps(comps);
        assertTrue(model.getEditableComps().size() == 2);
    }

    @Test
    void setAuthorIDTest()
    {
        Integer authorID = 1;
        model.setAccountID(authorID);
        assertTrue(model.getAccountID().equals(authorID));
    }
}