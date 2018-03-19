package com.micetr0.mock_DB;

import com.micetr0.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Mock_DB {

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
}
