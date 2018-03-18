/*
 *     Server-Side Composition model class
 *     Composition.java
 *     Created Mar 06, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class Composition {

    public Composition() {
        //empty constructor
    }

    private String title = "Untitled";
    private Integer year;
    private String account = null;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {return year;}

    public void setYear(Integer year) {this.year = year;}

    public String getAuthor() {
        return account;
    }

    public void setAuthor(String account) {
        this.account = account;
    }
}