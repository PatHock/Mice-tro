package com.micetr0.mock_DB;

import com.micetr0.model.*;
import com.sun.org.apache.xml.internal.security.Init;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class mock_DB {

   // private List<Account> accounts = new ArrayList<>();
    private List<Section> sections = new ArrayList<>();
    private List<Composition> compositions = new ArrayList<>();
    private List<Measure> measures = new ArrayList<>();
    private List<Note> notes = new ArrayList<>();

    public void FakeDatabase()
    {
        readInitialData();

        //System.out.println(accounts.size() + "accounts");
        System.out.println(compositions.size() + "compositions");
        System.out.println(sections.size() + "sections");
        System.out.println(measures.size() + "measures");
        System.out.println(notes.size() + "notes");
    }

    public void readInitialData() {

        try{
            //accounts.addAll();
            compositions.addAll(InitialData.getCompositions());
            sections.addAll(InitialData.getSections());
            measures.addAll(InitialData.getMeasusres());
            notes.addAll(InitialData.getNotes());
        }
        catch (IOException e)
        {
            throw new IllegalStateException("Couldn't read initial data", e);
        }
    }

}
