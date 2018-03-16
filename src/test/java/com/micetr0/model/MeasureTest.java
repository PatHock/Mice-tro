package com.micetr0.model;

import org.junit.Test;
import com.micetr0.model.Note;

import static org.junit.Assert.*;

public class MeasureTest {
    private Note note = new Note(Note.Pitch.A0, Note.Type.SIXTEENTH);
    private Measure measure = new Measure();

    @Test
    public void addNote() {
        assertEquals(measure.getNumNotes(), 0);
        measure.addNote(note.getPitch(), note.getType(), 0);
        // expect this one to throw an exception
        measure.addNote(note.getPitch(), note.getType(), 10);

    }

    @Test
    public void deleteNote() {
    }

    @Test
    public void setMaxNumBeats() {
    }
}