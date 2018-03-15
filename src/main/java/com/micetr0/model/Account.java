package com.micetr0.model;

import java.util.ArrayList;
import java.util.List;

public class Account {

    public Account(){
        // empty constructor
    }

    String password = null;
    String username = null;
    List<Composition> compositions = new ArrayList<Composition>();


    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public boolean checkCredentials(String username, String Password){
        throw new UnsupportedOperationException();
    }

    public Account createAccount(String username, String Password){
        throw new UnsupportedOperationException();
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
    private Account logIn(String username, String password){
        throw new UnsupportedOperationException();
    }

}
