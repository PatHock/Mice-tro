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
    List<Pair<String,String>> accounts = new ArrayList<>();
    @Before
    public void setUp()
    {
        model = new Account();
    }

    @Test
    public void getPasswordTest() {
        throw new UnsupportedOperationException();
    }

    @Test
    public void setPasswordTest(){
        throw new UnsupportedOperationException();
    }

    @Test
    public void getUsernameTest() {
        throw new UnsupportedOperationException();
    }

    @Test
    public void setUsernameTest() {
        throw new UnsupportedOperationException();
    }

    @Test
    public void getCompositionTest() {
        throw new UnsupportedOperationException();
    }

    @Test
    public void setCompositionTest() {
        throw new UnsupportedOperationException();
    }

    @Test
    public void getAccountsTest() {
        accounts.add(new Pair<String,String>("user","password"));
        accounts.add(new Pair<String,String>("hoodlum","drowssap"));
        model.setAccounts(accounts);
        assertTrue(accounts.get(0).getKey().equals(model.getAccounts().get(0).getKey()));
        assertTrue(accounts.get(1).getKey().equals(model.getAccounts().get(1).getKey()));
    }

    @Test
    public void setAccountsTest() {
        accounts.add(new Pair<String,String>("user","password"));
        accounts.add(new Pair<>("hoodlum","drowssap"));
        assertTrue(accounts.get(0).getKey().equals(model.getAccounts().get(0).getKey()));
        assertTrue(accounts.get(1).getKey().equals(model.getAccounts().get(1).getKey()));

    }

    @Test
    public void getCurrCompositionTest(){
        throw new UnsupportedOperationException();
    }

    @Test
    public void setCurrCompositionTest() {
        throw new UnsupportedOperationException();
    }
}