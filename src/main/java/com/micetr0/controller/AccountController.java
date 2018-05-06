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
        List<Account> accountList;
        Account account;
        Integer accountId;

        // TODO: check for username, password not long enough.

        accountList = db.findAccountByUsername(username);

        if(accountList.size() > 0) {
            account = null;
        } else {
            accountId = db.insertAccount(username, password);
            account = db.findAccountByAccountID(accountId).get(0);
        }

        return account;
    }

    public void deleteAccount(String username) {
        db.deleteAccount(username);
    }


    // https://codereview.stackexchange.com/questions/63283/password-validation-in-java
    public Integer logIn(String username, String password) {

        List<Account> accountIds = db.findAccountByUsernameAndPassword(username, password);

        switch (accountIds.size()) {
            case 0:
                return null;
            case 1:
                return accountIds.get(0).getAccountID();
            default:
                throw new DataIntegrityViolationException("More than one account ID associated with username");
        }

    }
}



