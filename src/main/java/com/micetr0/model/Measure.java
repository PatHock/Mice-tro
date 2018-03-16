/*
 *     Server-Side Measure model class
 *     Measure.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;
import java.util.LinkedList;
import java.lang.Exception;

public class Measure {

    private Double sizeLimit;
    private LinkedList<Note> notes = new LinkedList<>();


    /*TODO: Measure must take time signature as an argument (two integers)
     * Measure Constructor
     */
    public Measure(Double size){
        this.size = size;
        // take num Beats as an argument and populate with rests
    }

    /**
     *
     * @param pitch the frequency of the note in Hertz
     * @param type the length of the note (sixteenth, eighth etc)
     * @param index the position of the note in the measure, starts at 0
     */
    public void addNote (Note.Pitch pitch, Note.Type type, int index) {
        // Check if index is valid
//        try {
//            if (index)
//            notes.add(index, new Note(pitch, type));
//        }catch(IndexOutOfBoundsException e){
//            System.err.println("IndexOutOfBoundsException" + e.getMessage());
//        }
//
//        if(index <= notes.size()-1){
//            try {
//                notes.add(index, new Note(pitch, type));
//            } catch(IndexOutOfBoundsException e){
//
//            }
//        }

        // need to check if the index is valid
        // need to check if the measure is full or not
    }

    /**
     * @param index The index in a LinkedList where notes are stored
     */
    public void deleteNote (int index) {

        // need to
    }


//    /**
//     * @param beats The number of beats in a measure per the time signature
//     */
//    public void setMaxNumBeats(int beats) {
//        maxBeats = beats;
//    }

//    /**
//     * @return maxBeats The number of beats in a measure per the time signature
//     */
//    public int getMaxNumBeats() {
//
//        return maxBeats;
//    }

    /**
     *
     * @return Returns the size of the LinkedList of notes within a measure
     */
    public int getNumNotes() {
        return notes.size();
    }

//    /**
//     *
//     * @param index - Index of note array, starts at zero
//     * @return Note object
//     */
//    public Note getNote(int index) {
//        return
//    }
}
