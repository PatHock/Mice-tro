package com.micetr0.model;

import java.rmi.UnexpectedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.micetr0.model.Composition;


public class Account {

    public Account() {
        // empty constructor
    }

    private String password;
    private String username;
    private Integer accountID;

    //removed to wait for sharing strech goal implementation
    //private List<Composition> viewableComps = new ArrayList<>();
    private List<Composition> editableComps = new ArrayList<>();


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

    public List<Composition> getEditableComps(){ return editableComps; }

    public void setEditableComps(List<Composition> editableComps) { this.editableComps = editableComps; }

    public Integer getAccountID()
    {
        return accountID;
    }

    public void setAccountID(Integer accountID)
    {
        this.accountID = accountID;
    }

    /*//might need for sharing stretch goal
    public List<Composition> getViewableComps(){ return viewableComps; }

    public void setViewableComps(List<Composition> viewableComps) { this.viewableComps = viewableComps; }
    */
}
