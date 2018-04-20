package com.micetr0.mock_DB;

import com.micetr0.definitions.Defs;
import com.micetr0.model.*;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.dao.DataIntegrityViolationException;

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
    public void insertNote(String type, String pitch, Integer measureIndex, Integer measureId) {
        Integer noteId = notes.get(notes.size() - 1).getNoteID() + 1;

        Note note = new Note(noteId,Defs.NoteType.valueOf(type),Defs.Pitch.valueOf(pitch),measureIndex,measureId);

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
    public List<Composition> findCompositionsByAccountId(Integer accountId)
    {
        List<Composition> compositionList = new ArrayList<>();

        for (Composition composition : compositions) {
            if (composition.getAccountId().equals(accountId)) {
                compositionList.add(composition);
            }
        }

        return compositionList;
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
    public List<Account> findAccountByAccountID(Integer accountId)
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
     * @param compositionId Unique Id for composition.
     * @return isCompDeleted: true if deletion was successful, false if deletion failed (composition did
     * not exist, etc
     */
    @Override
    public Boolean deleteComposition(Integer compositionId) {
        Boolean isCompDeleted = false;

        for(Composition composition : compositions) {
            if (composition.getCompositionID().equals(compositionId)){
                compositions.remove(composition);
                isCompDeleted = true;
            }
        }

        return isCompDeleted;
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
    public void deleteAccount(String username)
   {
       //TODO: Boolean
       List<Account> accIds = findAccountByUsername(username);

       if(accIds.size() > 1){
           //too many accounts in returned account list, should only be one, throw exception
           throw new DataIntegrityViolationException("More than one account exists with this username");
       }

       for (Account acc : accounts)
       {
           if (acc.getUsername().equals(username)) {
               accounts.remove(acc);
           }
       }

   }


    /**
     *
     * @param username unique username entered by user when logging in
     * @return List of Account ID's that have the specified username
     */
    @Override
    public List<Account> findAccountByUsername(String username) {
        List<Account> accountIdList = new ArrayList<>();

        for (Account acc : accounts) {
            if(acc.getUsername().equals(username)) {
                accountIdList.add(acc);
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

    /**
     * @param compositionId Unique Identifier for compositions.
     * @param title         The title of a composition. Editable by the user.
     * @return Boolean isCompUpdated: True when update operation is successful, false otherwise
     */
    @Override
    public Boolean updateCompositionTitleByCompositionId(Integer compositionId, String title) {
        Boolean isCompUpdated = false;

        for (Composition composition : compositions) {
            if (composition.getCompositionID().equals(compositionId)) {
                composition.setTitle(title);
                isCompUpdated = true;
            }
        }

        return isCompUpdated;
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

    /**
     * @param userName Unique Username, input by user at login
     * @param password User's password, for verifying login
     * @return Integer accountId: Unique account ID generated by the db on account creation
     */
    @Override
    public Integer insertAccount(String userName, String password) {
        Account account = new Account();
        Integer accountId = accounts.get(accounts.size() - 1).getAccountID() + 1;
        account.setAccountID(accountId);
        account.setUsername(userName);
        account.setPassword(password);
        accounts.add(account);
        return accountId;
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

    /**
     * @param compositionId Unique Identifier for compositions.
     * @param year          Integer year when the composition was written
     * @return Boolean, true indicates that update was successful, false indicates that update failed (invalid composition ID)
     */
    @Override
    public Boolean updateCompositionYearByCompositionId(Integer compositionId, Integer year) {
        for (Composition composition : compositions) {
            if(composition.getCompositionID().equals(compositionId)){
                composition.setYear(year);
                return true;
            }
        }
        return false;
    }

    /**
     * Creates a composition from given title, description, and year. Generates unique ID
     *
     * @param title              The name of the composition.
     * @param description        A string that describes the purpose etc of the composition
     * @param year               The year the composition was written
     * @param isViewablePublicly Integer, should be 0 to indicate that comp is not viewable Publicly, or 1
     *                           to indicate that it is viewable publicly. Like a boolean, but actually an
     *                           Integer
     * @param accountId          Integer that identifies which account owns this composition
     * @return A composition object with unique ID
     */
    @Override
    public Integer insertComposition(String title, String description, Integer year, Boolean isViewablePublicly, Integer accountId) {
        Composition composition = new Composition();
        composition.setTitle(title);
        composition.setDesc(description);
        composition.setYear(year);
        composition.setIsViewablePublicly(isViewablePublicly);
        composition.setAccountId(accountId);

        Integer compositionId = compositions.get(compositions.size() - 1).getCompositionID() + 1;
        composition.setCompositionID(compositionId);

        compositions.add(composition);
        return compositionId;
    }



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

    @Override
    public Boolean insertSection(Integer sectionID, Defs.Key key, Defs.TimeSignature timeSig, Defs.Clef clef, Integer tempo, Integer composition_ID) {
        Section section = new Section();
        Integer sectionId = sections.get(sections.size() - 1).getSectionID() + 1;
        section.setSectionID(sectionId);
        section.setCompID(composition_ID);
        section.setClef(clef);
        section.setKey(key);
        section.setTimeSig(timeSig);
        section.setTempo(tempo);
        sections.add(section);
        return true;
    }

    @Override
    public Boolean deleteSection(Integer sectionID) {
        for (Section section : sections) {
            if(section.getSectionID().equals(sectionID)) {
                sections.remove(section);
                return true;
            }
        }
        return false;
    }

    @Override
    public Section findSection(Integer sectionID) {
        List<Section> newSections = new ArrayList<>();
        for(Section section : sections)
        {
            if(section.getSectionID().equals(sectionID)){
                newSections.add(section);
            }
        }
        return newSections.get(0);  //Sections should never be larger than 1.
    }

    @Override
    public List<Section> findAllSections() {
        List<Section> newSections = new ArrayList<>();
        for (Section section : sections){
            newSections.add(section);
        }
        return newSections;
    }

}

