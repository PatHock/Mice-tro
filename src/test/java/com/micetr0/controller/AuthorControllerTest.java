package com.micetr0.controller;

import com.micetr0.model.Account;
import javafx.util.Pair;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class AuthorControllerTest {

    private Account model;
    private AccountController controller;

    @Before
    public void createModel() {
        model = new Account();
        controller = new AccountController();
        controller.setModel(model);
    }

    @Test
    public void initAccountsTest()
    {
        List<Pair<String,String>> accounts = new ArrayList<>();
        controller.initAccounts();
        accounts = model.getAccounts();
        assertTrue(accounts.get(0).getKey().equals("uber_user"));
        assertTrue(accounts.get(1).getKey().equals("Rick"));
        assertTrue(accounts.get(0).getValue().equals("password"));
        assertTrue(accounts.get(1).getValue().equals("pASSword"));
    }

    @Test
    public void createAccountTest()
    {
        List<Pair<String,String>> accounts = new ArrayList<>();
        controller.initAccounts();
        boolean newAccount = controller.createAccount("Pat","password",accounts);
        accounts = model.getAccounts();
        assertTrue(newAccount == true);
        assertTrue(accounts.get(2).getKey().equals("Pat"));
        newAccount = controller.createAccount("uber_user", "notGonnaHappen", accounts);
        assertTrue(newAccount == false);
        assertFalse(accounts.size() == 4);
    }

    @Test
    public void deleteAccountTest()
    {
        List<Pair<String,String>> accounts = new ArrayList<>();
        controller.initAccounts();
        boolean deleted = controller.deleteAccount("uber_user");
        assertTrue(model.getAccounts().get(0).getKey().equals("Rick"));
        assertTrue(deleted == true);
        assertTrue(model.getAccounts().size() == 1);
    }

    @Test
    public void addCompositionTest()
    {
        throw new UnsupportedOperationException();
    }

    @Test
    public void removeCompositionTest()
    {
        throw new UnsupportedOperationException();
    }

    @Test
    public void logOutTest()
    {
        throw new UnsupportedOperationException();
    }

    @Test
    public void logInTest()
    {
        throw new UnsupportedOperationException();
    }
}
