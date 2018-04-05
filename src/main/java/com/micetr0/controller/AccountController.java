package com.micetr0.controller;

import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.mock_DB.InitDatabase;
import com.micetr0.model.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountController {

    Account account = new Account();
    private IDatabase db;
    private List<Account> dbAccounts = new ArrayList<>();

    public AccountController()
    {
        InitDatabase.init(true);
        db = DatabaseProvider.getInstance();
    }

    public void setModel(Account account) {
        this.account = account;
    }

    public List<Account> getAllAccounts()
    {
        dbAccounts = db.findAllAccounts();
        return dbAccounts;
    }
    private boolean checkCredentials(String username, String password, List<Account> accounts) {
        boolean validAccount = false;

        for (Account account : accounts) {
            if (account.getUsername().equals(username) && account.getPassword().equals(password)) {
                validAccount = true;
                return validAccount;
            }
        }   return validAccount;
    }

    public Account createAccount(String username, String password, List<Account> accounts) {
        try {
            Account newAccount = new Account();
            newAccount.setUsername(username);
            newAccount.setPassword(password);
            return newAccount;
        }
        catch(Exception e)
        {
            throw e;
        }

    }

    public boolean deleteAccount(String username, List<Account> accounts)
    {
        for (Account account : accounts)
        {
            if(account.getUsername() == username)
            {
                accounts.remove(account);
                return true;
            }
        }
        return false;
    }

    public void logOut(Account account){
        // jsp method?
    }

    public Account logIn(String username, String password, List<Account> accounts){
        boolean validAccount = checkCredentials(username, password, accounts);
            if (validAccount) {
                Account currAccount = accounts.get(accounts.indexOf(username)+1);
                return currAccount;
            }
            else {
                //should throw some exception ie(account does not exist)
            }
            return null;
        }
    }

    //Need to add method to add new account to database
