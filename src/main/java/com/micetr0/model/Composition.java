/*
 *     Server-Side Composition model class
 *     Composition.java
 *     Created Mar 06, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Composition {

    public Composition() {
        //empty constructor
    }

    private Integer compositionID;
    private String title = "Untitled";
    private Integer year;
    private String desc = null;
    private Integer accountID;
    private Integer viewable;


    public Integer getCompositionID()
    {
        return compositionID;
    }

    public void setCompositionID(Integer compositionID)
    {
        this.compositionID = compositionID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {return year;}

    public void setYear(Integer year) {this.year = year;}

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }

    public Integer getAccountID() {
        return accountID;
    }

    public void setAccountID(Integer accountID) {
        this.accountID = accountID;
    }

    public Integer getViewable() {
        return viewable;
    }

    public void setViewable(Integer viewable) {
        this.viewable = viewable;
    }
}