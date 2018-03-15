/*
 *     Server-Side Measure Controller class
 *     MeasureController.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */
package com.micetr0.controller;
import com.micetr0.model.Note;
import com.micetr0.model.Measure;

public class MeasureController {

    Measure measure = new Measure();

    //TODO: Implement
    void addNote(float pitch, Note.Type Type, int index) {
        Note note = new Note();

        try{
            // insert code here
        }
        catch (IndexOutOfBoundsException e) {
            System.err.println("IndexOutOfBoundsException" + e.getMessage());
        }
    }
}
