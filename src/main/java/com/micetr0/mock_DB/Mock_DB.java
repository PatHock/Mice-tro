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

    @Override
    public void insertNote(Note note) {

        Integer noteId = notes.get(notes.size() - 1).getNoteID() + 1;
        note.setNoteID(noteId);

        notes.add(note);
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


    /**
     *
     */
    @Override
    public List<Composition> findCompositionsIdsByAccountId(Integer accountId)
    {
        List<Composition> resultList = new ArrayList<>();
        List<String> compList = new ArrayList<>();
        for (Account account : accounts)
        {
            if(account.getAccountID() == accountId)
            {
                compList.addAll(account.getViewableComps());
                compList.addAll(account.getEditableComps());
            }
        }
        resultList = findCompositionsByCompIds(compList);
        return resultList;
    }

    private List<Composition> findCompositionsByCompIds(List<String> compIds)
    {
        List<Composition> resultList = new ArrayList<>();

        for (Composition comp : compositions)
        {
            for(String compId : compIds)
            {
                if(compId.equals(String.valueOf(comp.getCompositionID())))
                {
                    resultList.add(comp);
                }
            }
        }
        return resultList;
    }

    public List<Account> findAllAccounts()
    {
        List<Account> resultList = new ArrayList<>();
        for (Account account : accounts)
        {
            resultList.add(account);
        }
        return resultList;
    }
    public List<Account> findCurrentAccount(Integer accountId)
    {
        List<Account> resultList = new ArrayList<>();
        for (Account account : accounts)
        {
            if(account.getAccountID().equals(accountId))
            {
                resultList.add(account);
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

    @Override
    public void insertComposition(Composition composition)
    {
        Integer compositionId = compositions.get(compositions.size() - 1).getCompositionID() + 1;
        composition.setCompositionID(compositionId);
        compositions.add(composition);
    }

    @Override
    public void deleteComposition(Integer compositionId)
    {
        List<String> compId = new ArrayList<>();
        compId.add(String.valueOf(compositionId));
        List<Composition> comp = findCompositionsByCompIds(compId);
        compositions.remove(comp.get(0));

    }

   @Override
    public void deleteAccount(Integer accountId)
   {
       List<Account> acc = findCurrentAccount(accountId);
       accounts.remove(acc.get(0));
   }

   @Override
   public void insertAccount(Account account)
   {
       Integer accountId = accounts.get(accounts.size() - 1).getAccountID() + 1;
       account.setAccountID(accountId);
       accounts.add(account);
   }

   @Override
    public List<Composition> findAllComps()
   {
       List<Composition> comps = new ArrayList<>();
       for (Composition comp : compositions)
       {
           comps.add(comp);
       }
       return comps;
   }


}

