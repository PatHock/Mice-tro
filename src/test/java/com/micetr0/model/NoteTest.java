package com.micetr0.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import com.micetr0.definitions.Defs;


class NoteTest {

    // Create new note object
    private Note note = new Note(1,Defs.NoteType.SIXTEENTH, Defs.Pitch.REST, 0, 0);

    @Test
    void initTest(){
        Defs.NoteType type = Defs.NoteType.QUARTER;
        Defs.Pitch pitch = Defs.Pitch.D1;
        Integer noteId = 1, measureIndex = 1, measureId = 2, sectionId = 3, compositionId = 4;

        Note testNote = new Note(noteId,type, pitch, measureIndex, measureId);
        assertEquals(testNote.getNoteID(),noteId);
        assertEquals(testNote.getType(), type);
        assertEquals(testNote.getPitch(), pitch);
        assertEquals(testNote.getMeasureId(), measureId);
        assertEquals(testNote.getMeasureIndex(), measureIndex);
    }

    @Test
    void setType(){
        note.setType(Defs.NoteType.SIXTEENTH);
        assertEquals(Defs.NoteType.SIXTEENTH, note.getType());

        note.setType(Defs.NoteType.EIGHTH);
        assertEquals(Defs.NoteType.EIGHTH, note.getType());
    }

    @Test
    void getTypeTest() {
        note.setType(Defs.NoteType.SIXTEENTH);
        assertEquals(Defs.NoteType.SIXTEENTH, note.getType());

        note.setType(Defs.NoteType.EIGHTH);
        assertEquals(Defs.NoteType.EIGHTH, note.getType());
    }

    @Test
    void setPitch(){
        note.setPitch(Defs.Pitch.E0);
        assertEquals(Defs.Pitch.E0, note.getPitch());
        note.setPitch(Defs.Pitch.C1);
        assertEquals(note.getPitch(), Defs.Pitch.C1);
    }

    @Test
    void getPitch(){
        note.setPitch(Defs.Pitch.E0);
        assertEquals(Defs.Pitch.E0, note.getPitch());
        note.setPitch(Defs.Pitch.C1);
        assertEquals(note.getPitch(), Defs.Pitch.C1);
    }

    @Test
    void getFrequency() {
        note.setPitch(Defs.Pitch.E0);
        assertEquals(Defs.Pitch.E0.getFrequency(), note.getFrequency());
        note.setPitch(Defs.Pitch.F1);
        assertEquals(Defs.Pitch.F1.getFrequency(), note.getFrequency());
    }

    @Test
    void testSize() {
        assertTrue(Defs.NoteType.SIXTEENTH.getSize() == .0625);
        assertTrue(Defs.NoteType.EIGHTH.getSize() == 0.125);
    }

    @Test
    void setMeasureId() {
        note.setMeasureId(0);
        assertEquals(note.getMeasureId(), (Integer) 0);

        note.setMeasureId(20000);
        assertEquals(note.getMeasureId(), (Integer)20000);

        note.setMeasureId(999999);
        assertEquals(note.getMeasureId(), (Integer)999999);
    }

    @Test
    void setMeasureIndex() {
        note.setMeasureIndex(2000);
        assertEquals(note.getMeasureIndex(), (Integer)2000);

        note.setMeasureIndex(0);
        assertEquals(note.getMeasureIndex(), (Integer)0);

        note.setMeasureIndex(99999999);
        assertEquals(note.getMeasureIndex(), (Integer)99999999);
    }

}