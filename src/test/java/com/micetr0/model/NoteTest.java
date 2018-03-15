package com.micetr0.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTest {
    private Note note = new Note();
    private static final Double delta = 1e-15;

    @Test
    public void init(){
        assertEquals(note.isSetType(), false);
        assertEquals(Note.Type.REST, note.getType());
    }

    @Test
    public void setType() {
        note.setType(Note.Type.SIXTEENTH);
        assertEquals(Note.Type.SIXTEENTH, note.getType());

        assertEquals(note.isSetType(), true);

        note.setType(Note.Type.EIGHTH);
        assertEquals(Note.Type.EIGHTH, note.getType());
    }

    @Test
    public void setPitch(){
        assertEquals(note.getPitch(), null);

        Double testDouble = 4025.5457;
        note.setPitch(testDouble);
        assertEquals(testDouble, note.getPitch(), delta);
    }


}