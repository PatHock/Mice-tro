package com.micetr0.mock_DB;

import com.micetr0.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mock_DB implements IDatabase{

    private List<Account> accounts;
    private List<Section> sections;
    private List<Composition> compositions;
    private List<Note> notes;

    public Mock_DB()
    {
        accounts = new ArrayList<>();
        notes = new ArrayList<>();
        sections = new ArrayList<>();
        compositions = new ArrayList<>();

        readInitialData();

        System.out.println(accounts.size() + "accounts");
        System.out.println(compositions.size() + "compositions");
        System.out.println(sections.size() + "sections");
        System.out.println(notes.size() + "notes");

    }

    private void readInitialData() {

        try{
            accounts.addAll(InitialData.getAccounts());
            compositions.addAll(InitialData.getCompositions());
            sections.addAll(InitialData.getSections());
            notes.addAll(InitialData.getNotes());
        }
        catch (IOException e)
        {
            throw new IllegalStateException("Couldn't read initial data", e);
        }
    }

    /**
     *
     * @param section
     * @param composition
     * @param measure
     * @return
     */
    public Note findNote(String section, String composition, String measure, String index)
    {
     for(Note note:notes){

         //determine how to find note
         return note;
     }
     return null;
    }


    @Override
    public void insertNote(String pitch, String type, String compositionId, String sectionId, String measureId, Integer measureIndex) {
        throw new UnsupportedOperationException("Please implement insertNote()");
    }

    /**
     * Multiple notes can exist in the same index in a measure (for a chord), so noteId is the only way
     * to properly distinguish notes
     *
     * @param noteId Unique database ID for note
     */
    @Override
    public void deleteNote(String noteId) {
        throw new UnsupportedOperationException("Please implement deleteNote()");
    }

    @Override
    public List<Note> findNotesByMeasureId(String measureId) {
        throw new UnsupportedOperationException("Please implement findNotesByMeasureId()");
    }
}
