package com.micetr0.controller;

import com.micetr0.model.Account;
import com.micetr0.model.Composition;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class AccountController {

    Account account = new Account();
    List<Pair<String,String>> accounts = new ArrayList<>();

    private boolean checkCredentials(String username, String Password, List<Pair<String,String>> accounts){
        boolean validAccount = false;
        
        return validAccount;
    }

    private void initAccounts()
    {
        accounts = account.getAccounts();
        account.setPassword("password");
        account.setUsername("uber_user");
        accounts.add(new Pair<String,String>(account.getUsername(),account.getPassword()));
        account.setUsername("Rick");
        account.setPassword("pASSword");
        accounts.add(new Pair<String,String>(account.getUsername(),account.getPassword()));
        account.setAccounts(accounts);
    }

    public void createAccount(String username, String password, List<Pair<String,String>> accounts){
        account.setPassword("password");
        account.setUsername("user1");
        username = account.getUsername();
        password = account.getPassword();
        accounts.add(new Pair<String,String>(username,password));
    }

    public void deleteAccount(Account account)
    {
        throw new UnsupportedOperationException();
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
