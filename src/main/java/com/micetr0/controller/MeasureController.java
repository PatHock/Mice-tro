/*
 *     Server-Side Measure Controller class
 *     MeasureController.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */
package com.micetr0.controller;
import com.micetr0.model.Note;
import com.micetr0.model.Measure;

import java.util.List;

public class MeasureController {
    private Measure measure = new Measure();

    public MeasureController()
    {
        //empty constructor
    }

    public void setUp(Measure measure) {
        this.measure = measure;
    }
    public void setMaxLen(int len)
    {

    }

    public void updateMaxLen(double maxlen)
    {
        measure.setSizeLimit(maxlen);
    }

    public void updateNoteArray(List<Note> notes)
    {
        measure.setNotes(notes);
    }


     public void addNote(Note.Pitch pitch, Note.Type type, int index) {
        List<Note> notes = measure.getNotes();
        Note note = new Note();
        note.setPitch(pitch);
        note.setType(type);
        if(isValidNote(note)) {
            notes.add(index, note);
        }
     }


     public void deleteNote(int index)
     {
         List<Note> notes = measure.getNotes();
         if(notes.size() > 0 && index <= notes.size() - 1) {
             Note rest = new Note();
             double len = notes.get(index).getType().getSize();
             rest.setPitch(Note.Pitch.REST);
             rest.setType(notes.get(index).getType());
             notes.remove(index);
             notes.add(index,rest);
         }
         measure.setNotes(notes);
     }

    public boolean isValidNote(Note newNote)
    {
        List<Note> notes = measure.getNotes();
        double len = 0;

        for (Note note: notes) {
            len += note.getType().getSize();
        }

        if((len+newNote.getType().getSize())<= measure.getSizeLimit())
        {
            return true;
        }

        return false;
    }
}