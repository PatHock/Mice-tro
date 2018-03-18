package com.micetr0.controller;

import com.micetr0.model.Measure;
import com.micetr0.model.Note;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class MeasureControllerTest {
    private MeasureController controller;
    private Measure model;

    @Before
    public void setUp()
    {
        controller = new MeasureController();
        model = new Measure();
        controller.setUp(model);
        controller.updateMaxLen(1);
    }

//    @Test
//    public void updateNoteArrayTest()
//    {
//        List<Note> notes = new ArrayList<Note>();
//        Note note1 = new Note();
//        Note note2 = new Note();
//        notes.add(note1);
//        notes.add(note2);
//        controller.updateNoteArray(notes);
//
//        assertTrue(notes == model.getNotes());
//    }



//    @Test
//    public void addNoteTest() {
//        controller.addNote(Note.Pitch.D0,Note.Type.HALF,0);
//        controller.addNote(Note.Pitch.A1,Note.Type.HALF,1);
//        controller.addNote(Note.Pitch.B0,Note.Type.HALF,2);
//
//        assertTrue(model.getNotes().size() == 2);
//        assertTrue(model.getNotes().get(1).getPitch().equals(Note.Pitch.A1));
//    }

//    @Test
//    public void deleteNoteTest()
//    {
//        int index = 3;
//        controller.addNote(Note.Pitch.D0,Note.Type.QUARTER,0);
//        controller.addNote(Note.Pitch.A1,Note.Type.REST_QUARTER,1);
//        controller.addNote(Note.Pitch.B0,Note.Type.QUARTER,2);
//        controller.addNote(Note.Pitch.C1,Note.Type.QUARTER,3);
//
//        controller.deleteNote(2);
//
//        List<Note> notes = model.getNotes();
//
//        assertTrue(notes.get(2).getPitch().equals(Note.Pitch.REST));
//    }

//    @Test
//    public void isValidNoteTest() {
//        List<Note> notes = new ArrayList<Note>();
//        Note note1 = new Note();
//        note1.setPitch(Note.Pitch.A1);
//        note1.setType(Note.Type.HALF);
//        Note note2 = new Note();
//        note2.setPitch(Note.Pitch.A1);
//        note2.setType(Note.Type.HALF);
//        notes.add(notes.size(),note1);
//        notes.add(notes.size(),note2);
//        Note note3 = new Note();
//        note3.setPitch(Note.Pitch.B0);
//        note3.setType(Note.Type.REST_EIGHTH);
//        controller.updateNoteArray(notes);
//        boolean valid = controller.isValidNote(note3);
//
//        assertFalse(valid);
//    }


}
