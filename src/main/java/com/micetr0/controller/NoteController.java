/*
 * Server-Side Note Controller class
 * NoteController.java
 * Created Mar 08, 2018 by Patrick Hock
 * Insert Description Here
 */
package com.micetr0.controller;
import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.mock_DB.InitDatabase;
import com.micetr0.model.Note;
import com.micetr0.definitions.Defs;
//import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * adds notes from database
 */
//@Controller
public class NoteController {

    private IDatabase db;
    private List<Note> dbNotes = new ArrayList<>();

    public NoteController() {
        db = DatabaseProvider.getInstance();
    }

    /**
     *
     * @param noteType Type of note as defined in definitions package
     * @param pitch Pitch as defined in definitions
     * @param key used for checking if note pitch exists within specified key
     * @param measureIndex position of note in measure, 0 being the first note
     * @param measureId Unique ID of the measure as stored in the measure database table
     */
    public void addNote(Defs.NoteType noteType, Defs.Pitch pitch, Defs.Key key, Integer measureIndex, Integer measureId) {
        // Check if the pitch of the note is valid
        if (!key.isValidPitch(pitch)) {
            throw new IllegalArgumentException("Note pitch is not contained within specified key");
        }


        // Cannot add two notes in the same measure, section, index that have the same pitch
        dbNotes = db.findNotesByMeasureIdAndMeasureIndex(measureId, measureIndex);

        if (!dbNotes.isEmpty()) {
            for (Note note: dbNotes) {
                if(note.getPitch().equals(pitch)){
                    throw new IllegalArgumentException("Note with this pitch already exists in database");
                }
            }
        }

        // If we made it this far, everything is juuuust fine
        db.insertNote(new Note(1, noteType, pitch, measureIndex, measureId));
    }

    /**
     * Fixme: This class exists for unit testing purposes only, to access the private db
     * Fixme: this method does not work properly
     * @param measureId MeasureId of note contained within NoteController's Database method
     * @param measureIndex Index of the note within the measure
     * @return ArrayList of note objects within specified measure, at specified measure index
     */
    public List<Note> getDbNotes(Integer measureId, Integer measureIndex) {
        return db.findNotesByMeasureIdAndMeasureIndex(measureId, measureIndex);
    }

}
