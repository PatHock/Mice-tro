/*
 *     Server-Side Measure model class
 *     Measure.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;
import java.util.ArrayList;
import java.util.LinkedList;
import java.lang.Exception;
import java.util.List;

public class Measure {
    private Double sizeLimit;
    private List<Note> notes = new ArrayList<Note>();
    private int currIndex;


    public Double getSizeLimit() {
        return sizeLimit;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setSizeLimit(Double sizeLimit) {
        this.sizeLimit = sizeLimit;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public int getCurrIndex() {
        return currIndex;
    }

    public void setCurrIndex(int currIndex){
        this.currIndex = currIndex;
    }

}
