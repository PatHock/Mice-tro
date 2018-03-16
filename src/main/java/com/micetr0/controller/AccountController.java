package com.micetr0.controller;

import com.micetr0.model.Account;
import com.micetr0.model.Composition;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class AccountController {

    Account account = new Account();
    List<Pair<String,String>> accounts = new ArrayList<>();

    public void setModel(Account account) {
        this.account = account;
    }

    private boolean checkCredentials(String username, String Password, List<Pair<String,String>> accounts){
        boolean validAccount = false;

        return validAccount;
    }

    public void initAccounts()
    {
        account.setPassword("password");
        account.setUsername("uber_user");
        accounts.add(new Pair<String,String>(account.getUsername(),account.getPassword()));
        account.setUsername("Rick");
        account.setPassword("pASSword");
        accounts.add(new Pair<String,String>(account.getUsername(),account.getPassword()));
        account.setAccounts(accounts);
    }

    public boolean createAccount(String username, String password, List<Pair<String,String>> accounts){
        accounts = account.getAccounts();
        for (Pair<String,String> account: accounts) {
            if(account.getKey().equals(username)) {
                return false;
            }
        }
        accounts.add(new Pair<String,String>(username,password));

        return true;
    }

    public boolean deleteAccount(String username)
    {
        for (Pair<String,String> account : accounts)
        {
            if(account.getKey().equals(username))
            {
                accounts.remove(account);
                return true;
            }
        }
        return false;
    }

    public void addComposition()
    {
        throw new UnsupportedOperationException();
    }
    public void removeComposition()
    {
        throw new UnsupportedOperationException();
    }
    public void logOut(Account account){
        throw new UnsupportedOperationException();
    }
    public void logIn(String username, String password, List<Pair<String,String>> accounts){
        initAccounts();
        int retry = 0;
        int maxRetry = 3;
        boolean validAccount = checkCredentials(username,password, accounts);
        if(retry < maxRetry) {
            if (validAccount) {

            } else {

            }
            retry ++;
        }
    }

    private void openComposition(List<Composition> compositions){
        throw new UnsupportedOperationException();
    }
}
