package com.micetr0.controller;

import com.micetr0.definitions.Defs;
import com.micetr0.model.Note;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NoteControllerTest {

    private NoteController controller;
    @BeforeEach
    void setUp(){
        controller = new NoteController();
    }

    @Test
    void addNote() {
        // Fixme getDbNotes() does not work in Note Controller
        Note note = new Note(1, Defs.NoteType.SIXTEENTH, Defs.Pitch.F8_SHARP, 2, 10);
        controller.addNote(note.getType(), note.getPitch(), Defs.Key.D_MAJOR, note.getMeasureIndex(), note.getMeasureId());

        // Only one note is added to db
//        assertTrue(controller.getDbNotes(note.getMeasureId(), note.getMeasureIndex()).size() == 1);
        // Check to see if note is stored in db
//        assertEquals(controller.getDbNotes(note.getMeasureId(), note.getMeasureIndex()).get(0), note);

        // adding the note again should cause an exception because two notes aren't allowed to overlap
        try {
            controller.addNote(note.getType(), note.getPitch(), Defs.Key.D_MAJOR, note.getMeasureIndex(), note.getMeasureId());
            fail("Did not throw exception for duplicate pitch note within a measure index");
        } catch(IllegalArgumentException e) {
        }

        // Add another note with different pitch to same measure index, should not throw exception
        controller.addNote(note.getType(), Defs.Pitch.A4, Defs.Key.D_MAJOR, note.getMeasureIndex(), note.getMeasureId());

        // try to add note with invalid pitch based on key
        try {
            controller.addNote(note.getType(), Defs.Pitch.A0_FLAT, Defs.Key.D_MAJOR, note.getMeasureIndex(), note.getMeasureId());
            fail("Did not throw exception for invalid pitch note based on Key");
        } catch(IllegalArgumentException e) {
        }
    }
}