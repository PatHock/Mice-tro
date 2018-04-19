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
        List<Composition> resultList;
        List<String> compList = new ArrayList<>();
        for (Account account : accounts)
        {
            if(account.getAccountID().equals(accountId))
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
    public void deleteAccount(String username)
   {
       List<Integer> accId = findAccountIdByUsername(username);
       for (Account acc : accounts)
       {
           if (acc.getAccountID().equals(accId.get(0)))
           {
               accounts.remove(acc);
               break;
           }
       }
   }

   @Override
   public void insertAccount(Account account)
   {
       Integer accountId = accounts.get(accounts.size() - 1).getAccountID() + 1;
       account.setAccountID(accountId);
       accounts.add(account);
   }

    /**
     *
     * @param username unique username entered by user when logging in
     * @return List of Account ID's that have the specified username
     */
    @Override
    public List<Integer> findAccountIdByUsername(String username) {
        List<Integer> accountIdList = new ArrayList<>();

        for (Account acc : accounts) {
            if(acc.getUsername().equals(username)) {
                accountIdList.add(acc.getAccountID());
            }
        }

        return accountIdList;
    }

    /**
     * @param compositionId Unique database-specific identification for a composition
     * @param description   A user-editable description for the composition
     * @return isCompUpdated: True when update operation is successful, false otherwise
     */
    @Override
    public Boolean updateCompositionDescriptionByCompositionId(Integer compositionId, String description) {

        for (Composition composition : compositions) {
            if(composition.getCompositionID().equals(compositionId)){
                composition.setDesc(description);
                return true;
            }
        }
        return false;
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

   @Override
    public List<Integer> findAccountIdByUsernameAndPassword(String username, String password) {
        List<Integer> accountIdList = new ArrayList<>();

        for (Account account : accounts) {
            if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
                accountIdList.add(account.getAccountID());
            }
        }

        return accountIdList;
   }

    /**
     * @param compositionId Unique ID that distinguishes a composition from others in the database.
     * @return an ArrayList of Composition objects that match the given composition ID
     */
    @Override
    public List<Composition> findCompositionsByCompositionId(Integer compositionId) {
        List<Composition> compositionList = new ArrayList<>();

        for (Composition composition: compositions) {
            if(composition.getCompositionID().equals(compositionId)) {
                compositionList.add(composition);
            }
        }

        return compositionList;
    }


    //    /**
//     * FIXME: needs unit test
//     * @param accountId Unique integer ID for accounts in database
//     * @return List of passwords that are associated with this account ID
//     */
//    @Override
//    public List<Credential> findUsernameAndPasswordByAccountId(Integer accountId) {
//        List<Credential> credentialList = new ArrayList<>();
//
//        for (Account acc : accounts) {
//            if(accountId.equals(acc.getAccountID())) {
//                credentialList.add(new Credential(acc.getUsername(), acc.getPassword()));
//            }
//        }
//
//        return credentialList;
//    }

    @Override
    public void deleteDB()
    {
        accounts.clear();
        sections.clear();
        compositions.clear();
        notes.clear();
    }

    @Override
    public void createDB()
    {
        if(accounts.isEmpty() && sections.isEmpty() && compositions.isEmpty() && notes.isEmpty()) {
            readInitialData();
        }
    }

}

