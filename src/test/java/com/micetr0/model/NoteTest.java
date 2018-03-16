package com.micetr0.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class NoteTest {

    private Note note = new Note();

    @Test
    public void setType(){
        note.setType(Note.Type.SIXTEENTH);
        assertEquals(Note.Type.SIXTEENTH, note.getType());

        note.setType(Note.Type.EIGHTH);
        assertEquals(Note.Type.EIGHTH, note.getType());
    }

    @Test
    public void getTypeTest() {
        note.setType(Note.Type.SIXTEENTH);
        assertEquals(Note.Type.SIXTEENTH, note.getType());

        note.setType(Note.Type.EIGHTH);
        assertEquals(Note.Type.EIGHTH, note.getType());
    }

    @Test
    public void setPitch(){
        note.setPitch(Note.Pitch.E0);
        assertEquals(Note.Pitch.E0, note.getPitch());
        note.setPitch(Note.Pitch.C1);
        assertEquals(note.getPitch(), Note.Pitch.C1);
    }

    @Test
    public void getPitch(){
        note.setPitch(Note.Pitch.E0);
        assertEquals(Note.Pitch.E0, note.getPitch());
        note.setPitch(Note.Pitch.C1);
        assertEquals(note.getPitch(), Note.Pitch.C1);
    }

    @Test
    public void getFrequency() {
        note.setPitch(Note.Pitch.E0);
        assertEquals(Note.Pitch.E0.getFrequency(), note.getFrequency());
        note.setPitch(Note.Pitch.F1);
        assertEquals(Note.Pitch.F1.getFrequency(), note.getFrequency());
    }
    @Test
    public void testSize() {
        assertTrue(Note.Type.SIXTEENTH.getSize() == .0625);
        Note note = new Note();
        note.setType(Note.Type.QUARTER);
        assertTrue(note.getType().getSize() == .25);
    }
}