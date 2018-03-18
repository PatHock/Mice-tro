package com.micetr0.model;

import org.junit.Before;
import org.junit.Test;
import com.micetr0.definitions.Defs;

import static org.junit.Assert.*;

public class NoteTest {

    // Create new note object
    private Note note = new Note(Defs.NoteType.REST_SIXTEENTH, Defs.Pitch.REST, 0, 0, 0, 0);

    @Test
    public void initTest(){
        Defs.NoteType type = Defs.NoteType.QUARTER;
        Defs.Pitch pitch = Defs.Pitch.D1;
        Integer measureIndex = 1, measureId = 2, sectionId = 3, compositionId = 4;

        Note testNote = new Note(type, pitch, measureIndex, measureId, sectionId, compositionId);

        assertEquals(testNote.getType(), type);
        assertEquals(testNote.getPitch(), pitch);
        assertEquals(testNote.getCompositionId(), compositionId);
        assertEquals(testNote.getMeasureId(), measureId);
        assertEquals(testNote.getMeasureIndex(), measureIndex);
        assertEquals(testNote.getSectionId(), sectionId);
    }

    @Test
    public void setType(){
        note.setType(Defs.NoteType.SIXTEENTH);
        assertEquals(Defs.NoteType.SIXTEENTH, note.getType());

        note.setType(Defs.NoteType.EIGHTH);
        assertEquals(Defs.NoteType.EIGHTH, note.getType());
    }

    @Test
    public void getTypeTest() {
        note.setType(Defs.NoteType.SIXTEENTH);
        assertEquals(Defs.NoteType.SIXTEENTH, note.getType());

        note.setType(Defs.NoteType.EIGHTH);
        assertEquals(Defs.NoteType.EIGHTH, note.getType());
    }

    @Test
    public void setPitch(){
        note.setPitch(Defs.Pitch.E0);
        assertEquals(Defs.Pitch.E0, note.getPitch());
        note.setPitch(Defs.Pitch.C1);
        assertEquals(note.getPitch(), Defs.Pitch.C1);
    }

    @Test
    public void getPitch(){
        note.setPitch(Defs.Pitch.E0);
        assertEquals(Defs.Pitch.E0, note.getPitch());
        note.setPitch(Defs.Pitch.C1);
        assertEquals(note.getPitch(), Defs.Pitch.C1);
    }

    @Test
    public void getFrequency() {
        note.setPitch(Defs.Pitch.E0);
        assertEquals(Defs.Pitch.E0.getFrequency(), note.getFrequency());
        note.setPitch(Defs.Pitch.F1);
        assertEquals(Defs.Pitch.F1.getFrequency(), note.getFrequency());
    }

    @Test
    public void testSize() {
        assertTrue(Defs.NoteType.SIXTEENTH.getSize() == .0625);
        assertTrue(Defs.NoteType.EIGHTH.getSize() == 0.125);
    }


    @Test
    public void getMeasureIndex() {
        note.setMeasureIndex(2000);
        assertEquals(note.getMeasureIndex(), (Integer)2000);

        note.setMeasureIndex(0);
        assertEquals(note.getMeasureIndex(), (Integer)0);

        note.setMeasureIndex(99999999);
        assertEquals(note.getMeasureIndex(), (Integer)99999999);
    }

    @Test
    public void getCompositionId() {
        note.setCompositionId(0);
        assertEquals(note.getCompositionId(), (Integer) 0);

        note.setCompositionId(20000);
        assertEquals(note.getCompositionId(), (Integer)20000);

        note.setCompositionId(99999999);
        assertEquals(note.getCompositionId(), (Integer)99999999);
    }

    @Test
    public void getMeasureId() {
        note.setMeasureId(0);
        assertEquals(note.getMeasureId(), (Integer) 0);

        note.setMeasureId(20000);
        assertEquals(note.getMeasureId(), (Integer)20000);

        note.setMeasureId(999999);
        assertEquals(note.getMeasureId(), (Integer)999999);
    }

    @Test
    public void getSectionId() {
        note.setSectionId(0);
        assertEquals(note.getSectionId(), (Integer) 0);

        note.setSectionId(20000);
        assertEquals(note.getSectionId(), (Integer)20000);

        note.setSectionId(99999999);
        assertEquals(note.getSectionId(), (Integer)99999999);
    }

    @Test
    public void setCompositionId() {
        note.setCompositionId(0);
        assertEquals(note.getCompositionId(), (Integer) 0);

        note.setCompositionId(20000);
        assertEquals(note.getCompositionId(), (Integer)20000);

        note.setCompositionId(99999999);
        assertEquals(note.getCompositionId(), (Integer)99999999);
    }

    @Test
    public void setMeasureId() {
    }

    @Test
    public void setMeasureIndex() {
        note.setMeasureIndex(2000);
        assertEquals(note.getMeasureIndex(), (Integer)2000);

        note.setMeasureIndex(0);
        assertEquals(note.getMeasureIndex(), (Integer)0);

        note.setMeasureIndex(99999999);
        assertEquals(note.getMeasureIndex(), (Integer)99999999);
    }

    @Test
    public void setSectionId() {
        note.setMeasureId(0);
        assertEquals(note.getMeasureId(), (Integer) 0);

        note.setMeasureId(20000);
        assertEquals(note.getMeasureId(), (Integer)20000);

        note.setMeasureId(999999);
        assertEquals(note.getMeasureId(), (Integer)999999);
    }
}