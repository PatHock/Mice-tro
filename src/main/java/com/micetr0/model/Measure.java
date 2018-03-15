/*
 *     Server-Side Measure model class
 *     Measure.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;
import java.util.LinkedList;
import java.util.List;

public class Measure {

    private int maxBeats;
    private LinkedList<Note> notes = new LinkedList<>();

    /**
     * @param note A Note object
     *
     */
    public void addNote (Note note, int index) {
        notes.add(index, note);
    }

    /**
     * @param index The index in a LinkedList where notes are stored
     */
    public void deleteNote (int index) {
    }


    /**
     * @param beats The number of beats in a measure per the time signature
     */
    public void setMaxNumBeats(int beats) {
        maxBeats = beats;
    }

    /**
     * @return maxBeats The number of beats in a measure per the time signature
     */
    public int getMaxNumBeats() {

        return maxBeats;
    }
}
