package com.micetr0.controller;

import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.mock_DB.InitDatabase;
import com.micetr0.model.Account;
import com.micetr0.model.Composition;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

public class AccountControllerTest {

    private Account model;
    private AccountController controller;
    private List<Account> accounts = new ArrayList<>();
    private IDatabase db;

    @Before
    public void createModel() {
        model = new Account();
        InitDatabase.init(true);
        controller = new AccountController();
        controller.setModel(model);
        db = DatabaseProvider.getInstance();
    }

    @Test
    public void createAccountTest()
    {
        Account newAccount = controller.createAccount("Pat", "password", accounts);
        assertTrue(newAccount.getUsername().equals("Pat"));
        assertTrue(newAccount.getPassword().equals("password"));

        Account newAccount2 = controller.createAccount("uber_user", "notGonnaHappen", accounts);
        assertTrue(newAccount2.getUsername().equals("uber_user"));
        assertTrue(newAccount2.getPassword().equals("notGonnaHappen"));
    }

    @Test
    public void deleteAccountTest()
    {
        Account newAccount = controller.createAccount("Pat", "password", accounts);
        Account newAccount2 = controller.createAccount("uber_user", "notGonnaHappen", accounts);
        accounts.add(newAccount);
        accounts.add(newAccount2);
        controller.deleteAccount("Pat", accounts);
        assertTrue(accounts.size() == 1);
        controller.deleteAccount("jay-z",accounts);

    }

    @Test
    public void logOutTest()
    {
        //throw new UnsupportedOperationException();
    }

    @Test
    public void logInTest()
    {
        List<Account> accounts =  new ArrayList<>();
        Account a1 = new Account();
        a1.setUsername("sad_Keanu");
        a1.setPassword("sad_Keanu_is_Sad");
        Account a2 = new Account();
        a2.setUsername("sad_Keanu");
        a2.setPassword("sad_Keanu");
        accounts.add(a1);
        accounts.add(a2);
        Account sad_Keanu = controller.logIn("sad_Keanu", "sad_Keanu_is_Sad", accounts);
        assertTrue(sad_Keanu.getUsername().equals("sad_Keanu"));
        Account sad_Keanu2 = controller.logIn("sad_Keanu", "sad_Keanu_is", accounts);
        assertNull(sad_Keanu2);
        Account sad_Keanu3 = controller.logIn("sad_Keanu", "sad_Keanu", accounts);
        assertTrue(sad_Keanu.getUsername().equals("sad_Keanu"));

    }

    @Test
    public void findAllAccountsTest()
    {
        List<Account> accounts = new ArrayList<>();
        accounts = controller.getAllAccounts();
        assertTrue(accounts.size() == 4);
    }
}
