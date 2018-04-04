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
     */
    @Override
    public List<Composition> findCompositionsIdsByAccountId(Integer accountId)
    {
        List<Composition> resultList = new ArrayList<>();
        List<Object> compList = new ArrayList<>();
        for (Account account : accounts)
        {
            if(account.getAccountID() == accountId)
            {
                compList.add(account.getEditableComps());
                compList.add(account.getViewableComps());

               resultList = findCompositionsByCompIds(compList);

            }
        }
        return resultList;
    }

    private List<Composition> findCompositionsByCompIds(List<Object> compIds)
    {
        List<Composition> resultList = new ArrayList<>();
        for (Composition comp : compositions)
        {
            for(Object compId : compIds)
            {
                if(comp.getCompositionID() == compId)
                {
                    resultList.add(comp);
                }
            }
        }
        return resultList;
    }


    /**
     *
     * @param measureId Unique ID for measure in database.
     * @param measureIndex  Position of a note in a measure, 0 being the first position
     * @return Arraylist of note objects that reside at a measure index
     */
    @Override
    public List<Note> findNotesByMeasureIdAndMeasureIndex(Integer measureId, Integer measureIndex) {
        List<Note> resultList = new ArrayList<>();
        for (Note note : notes) {
            if (note.getMeasureId().equals(measureId) && note.getMeasureIndex().equals(measureIndex)) {
                resultList.add(note);
            }
        }
        return resultList;
    }
}
