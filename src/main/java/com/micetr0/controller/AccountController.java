package com.micetr0.controller;


import java.util.ArrayList;
import java.util.List;

import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.model.Account;
import org.springframework.dao.*;


public class AccountController {

    private Account account = new Account();
    private IDatabase db;
    private List<Account> dbAccounts = new ArrayList<>();

    public AccountController() {
        db = DatabaseProvider.getInstance();
    }

    public List<Account> getAllAccounts() {
        dbAccounts = db.findAllAccounts();
        return dbAccounts;
    }

    public Integer addAccount(Account account) {
        //make sure account doesn't already exist!

        return db.insertAccount(account.getUsername(),account.getPassword());
    }

//    private Boolean checkCredentials(String username, String password, List<Account> accounts) {
//        Boolean isValidAccount = false;
//
//        for (Account account : accounts) {
//            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
//                isValidAccount = true;
//            }
//        }
//        return isValidAccount;
//    }

    public Account createAccount(String username, String password) {
        try {
            Account newAccount = new Account();
            newAccount.setUsername(username);
            newAccount.setPassword(password);
            return newAccount;
        } catch (Exception e) {
            throw e;
        }
    }

    public void deleteAccount(String username) {
        db.deleteAccount(username);
    }

    public void logOut(Account account) {
        // jsp method?
    }

    // https://codereview.stackexchange.com/questions/63283/password-validation-in-java
    public Boolean logIn(String username, String password) {

        List<Account> accountIds = db.findAccountByUsernameAndPassword(username, password);

        switch (accountIds.size()) {
            case 0:
                return false;
            case 1:
                return true;

            default:
                throw new DataIntegrityViolationException("More than one account ID associated with username");
        }

    }
}



