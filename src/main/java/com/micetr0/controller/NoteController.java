/*
 * Server-Side Note Controller class
 * NoteController.java
 * Created Mar 08, 2018 by Patrick Hock
 * Insert Description Here
 */

package com.micetr0.controller;
import com.micetr0.model.Note;
import com.micetr0.definitions.Defs;

public class NoteController {

    public NoteController() {
        //empty constructor
    }

    public void addNote(Defs.NoteType noteType, Defs.Pitch pitch, Defs.Key key, Integer measureIndex, Integer measureId, Integer sectionId, Integer compositionId) {
        //TODO: check to see if note exists in db? Interact with NoteFactory.java
        //TODO: Implement rule checking for the creation of notes

        // Check if the pitch of the note is valid
        if (!key.isValidPitch(pitch)) {
            throw new IllegalArgumentException("Note pitch is not contained within specified key");
        }

        // Does note exist in db?


        // assuming all went well with the database, put the note into the database

    }

}
