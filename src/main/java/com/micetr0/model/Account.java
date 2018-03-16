package com.micetr0.model;

import javafx.util.Pair;
import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Account {

    public Account(){
        // empty constructor
    }
    String password;
    String username;
    List<Composition> compositions = new ArrayList<>();
    List<Pair<String,String>> accounts;
    Composition currComposition;

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
    public List<Composition> getComposition() {
        return compositions;
    }
    public void setCompositions(List<Composition> compositions)
    {
        this.compositions = compositions;
    }
    public List<Pair<String,String>> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<Pair<String,String>> accounts)
    {
        this.accounts = accounts;
    }
    public Composition getCurrComposition()
    {
        return currComposition;
    }
    public void setCurrComposition(Composition currComposition)
    {
        this.currComposition = currComposition;
    }
}
