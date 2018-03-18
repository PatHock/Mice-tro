package com.micetr0.model;

import javafx.util.Pair;
import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Account {

    public Account() {
        // empty constructor
    }

    private String password;
    private String username;

    private List<Object> viewableComps = new ArrayList<>();
    private List<Object> editableComps = new ArrayList<>();

    private Integer accountID;

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

    public List<Object> getViewableComps(){ return viewableComps; }

    public void setViewableComps(List<Object> viewableComps) { this.viewableComps = viewableComps; }

    public List<Object> getEditableComps(){ return editableComps; }

    public void setEditableComps(List<Object> editableComps) { this.editableComps = editableComps; }

    public Integer getAccountID()
    {
        return accountID;
    }

    public void setAccountID(Integer accountID)
    {
        this.accountID = accountID;
    }
}
