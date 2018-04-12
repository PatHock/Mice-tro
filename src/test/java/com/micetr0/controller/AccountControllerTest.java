package com.micetr0.controller;

import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.mock_DB.Mock_DB;
import com.micetr0.model.Account;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccountControllerTest {
    private AccountController controller;
    private List<Account> accounts = new ArrayList<>();
    private IDatabase db;

    @BeforeEach
    void createModel() {
        //FIXME update
        DatabaseProvider.setInstance(new Mock_DB());
        db = DatabaseProvider.getInstance();
        controller = new AccountController();
    }

    @Test
    void addAccountTest()
    {
        Account newAccount = controller.createAccount("Pat", "pASSword");
        controller.addAccount(newAccount);
        List<Account> accounts = controller.getAllAccounts();
        assertTrue(accounts.get(accounts.size()-1).getUsername().equals("Pat"));
    }
    @Test
    void createAccountTest()
    {
        Account newAccount = controller.createAccount("Pat", "pASSword");
        assertTrue(newAccount.getUsername().equals("Pat"));
        assertTrue(newAccount.getPassword().equals("pASSword"));

        Account newAccount2 = controller.createAccount("uber_user", "notGonnaHappen");
        assertTrue(newAccount2.getUsername().equals("uber_user"));
        assertTrue(newAccount2.getPassword().equals("notGonnaHappen"));
    }

    @Test
    void deleteAccountTest()
    {

        Account newAccount = controller.createAccount("Rick", "pASSword");
        controller.addAccount(newAccount);
        List<Account> accounts = controller.getAllAccounts();
        assertTrue(accounts.get(accounts.size()-1).getUsername().equals("Rick"));
        controller.deleteAccount("Rick");
        accounts = controller.getAllAccounts();
        assertFalse(accounts.get((accounts.size()-1)).getUsername().equals("Rick"));
    }

    @Test
    void logOutTest()
    {
        //throw new UnsupportedOperationException();
    }

    @Test
    void logInTest()
    {
        assertFalse( controller.logIn("Rick", "password"));
        assertTrue(controller.logIn("sad_Keanu", "sad_Keanu_is_Sad"));
    }

    @Test
    void findAllAccountsTest()
    {
        assertTrue(controller.getAllAccounts().size() == 4);
    }
}
