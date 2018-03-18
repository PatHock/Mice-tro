/*
 * Server-Side Note Controller class
 * NoteController.java
 * Created Mar 08, 2018 by Patrick Hock
 * Insert Description Here
 */

package com.micetr0.controller;
import com.micetr0.model.Note;

public class NoteController {

    public NoteController() {
        //empty constructor
    }

    public void addNote(Note.Type type, Note.Pitch pitch, Integer measureIndex, Integer measureId, Integer sectionId, Integer compositionId) {
        //TODO: check to see if note exists in db? Interact with NoteFactory.java
        //TODO: Implement rule checking for the creation of notes
        throw new UnsupportedOperationException("Not supported yet fam");
    }

}
