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
        assertEquals("Pat", accounts.get(accounts.size() - 1).getUsername());
    }
    @Test
    void createAccountTest()
    {
        Account newAccount = controller.createAccount("Pat", "pASSword");
        assertEquals("Pat", newAccount.getUsername());
        assertEquals("pASSword", newAccount.getPassword());

        Account newAccount2 = controller.createAccount("uber_user", "notGonnaHappen");
        assertEquals("uber_user", newAccount2.getUsername());
        assertEquals("notGonnaHappen", newAccount2.getPassword());
    }

    @Test
    void deleteAccountTest()
    {
        Account newAccount = controller.createAccount("Rick", "pASSword");
        controller.addAccount(newAccount);
        List<Account> accounts = controller.getAllAccounts();
        assertEquals("Rick", accounts.get(accounts.size() - 1).getUsername());
        controller.deleteAccount("Rick");
        accounts = controller.getAllAccounts();
        assertNotEquals("Rick", accounts.get((accounts.size() - 1)).getUsername());
    }

    @Test
    void logOutTest()
    {
        //throw new UnsupportedOperationException();
    }

    @Test
    void logInTest()
    {
        assertFalse(controller.logIn("Rick", "password"));
        assertTrue(controller.logIn("sad_Keanu", "sad_Keanu_is_Sad"));
    }

    @Test
    void findAllAccountsTest()
    {
        assertEquals(4, controller.getAllAccounts().size());
    }
}
