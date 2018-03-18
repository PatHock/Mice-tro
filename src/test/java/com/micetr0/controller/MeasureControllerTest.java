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
//        controller.addNote(Defs.Pitch.D0,Defs.NoteType.HALF,0);
//        controller.addNote(Defs.Pitch.A1,Defs.NoteType.HALF,1);
//        controller.addNote(Defs.Pitch.B0,Defs.NoteType.HALF,2);
//
//        assertTrue(model.getNotes().size() == 2);
//        assertTrue(model.getNotes().get(1).getPitch().equals(Defs.Pitch.A1));
//    }

//    @Test
//    public void deleteNoteTest()
//    {
//        int index = 3;
//        controller.addNote(Defs.Pitch.D0,Defs.NoteType.QUARTER,0);
//        controller.addNote(Defs.Pitch.A1,Defs.NoteType.REST_QUARTER,1);
//        controller.addNote(Defs.Pitch.B0,Defs.NoteType.QUARTER,2);
//        controller.addNote(Defs.Pitch.C1,Defs.NoteType.QUARTER,3);
//
//        controller.deleteNote(2);
//
//        List<Note> notes = model.getNotes();
//
//        assertTrue(notes.get(2).getPitch().equals(Defs.Pitch.REST));
//    }

//    @Test
//    public void isValidNoteTest() {
//        List<Note> notes = new ArrayList<Note>();
//        Note note1 = new Note();
//        note1.setPitch(Defs.Pitch.A1);
//        note1.setType(Defs.NoteType.HALF);
//        Note note2 = new Note();
//        note2.setPitch(Defs.Pitch.A1);
//        note2.setType(Defs.NoteType.HALF);
//        notes.add(notes.size(),note1);
//        notes.add(notes.size(),note2);
//        Note note3 = new Note();
//        note3.setPitch(Defs.Pitch.B0);
//        note3.setType(Defs.NoteType.REST_EIGHTH);
//        controller.updateNoteArray(notes);
//        boolean valid = controller.isValidNote(note3);
//
//        assertFalse(valid);
//    }


}
