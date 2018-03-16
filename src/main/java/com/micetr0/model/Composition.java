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

    private String title = null;
    private String account = null;
    private List<Section> sections = new ArrayList<Section>();
    private Pair<String,Boolean> editable;
    private String viewer = null;
    public enum Mode{
        view,edit,play
    }
    private Mode mode;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUser() {
        return account;
    }
    public void setUser(String account) {
        this.account = account;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public Pair<String,Boolean> getEditable()
    {
        return editable;
    }

    public void setEditable(Pair<String,Boolean> editable) {
        this.editable = editable;
    }

    public Mode getMode()
    {
        return mode;
    }
    public void setMode(Mode mode)
    {
        this.mode = mode;
    }
    public void setViewer(String viewer)
    {
        this.viewer = viewer;
    }
    public String getViewer()
    {
        return viewer;
    }





}