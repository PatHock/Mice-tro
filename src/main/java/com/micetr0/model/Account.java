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

    String password;
    String username;

    List<Object> viewableComps = new ArrayList<>();
    List<Object> editableComps = new ArrayList<>();

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
}
