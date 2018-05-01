package com.micetr0.mock_DB;

import com.micetr0.definitions.Defs;
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
    public Integer insertNote(String type, String pitch, Integer measureIndex, Integer measureId) {
        Integer noteId = notes.get(notes.size() - 1).getNoteID() + 1;

        Note note = new Note(noteId,Defs.NoteType.valueOf(type),Defs.Pitch.valueOf(pitch),measureIndex,measureId);

        notes.add(note);

        return noteId;
    }

    /**
     * Multiple notes can exist in the same index in a measure (for a chord), so noteId is the only way
     * to properly distinguish notes
     *
     * @param noteId Unique database ID for note
     */
    @Override
    public boolean deleteNote(String noteId) {
        Boolean isNoteDeleted = false;

        for(Note note : notes) {
            if (note.getNoteID().equals(noteId)){
                notes.remove(note);
                isNoteDeleted = true;
            }
            if(isNoteDeleted){
                break;
            }
        }

        return isNoteDeleted;
    }


    /**
     *
     */
    public List<Composition> findCompositionsByAccountId(Integer accountId)
    {
        List<Composition> resultList = new ArrayList<>();
        for (Composition comp : compositions)
        {
            if(comp.getAccountId().equals(accountId))
            {
                resultList.add(comp);
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
    public Boolean deleteAccount(String username)
   {
       List<Account> accIds = findAccountByUsername(username);

       Boolean deleted = false;

       if(accIds.size() > 1){
           //too many accounts in returned account list, should only be one, throw exception
       }

       Account tempAccount = new Account();
       tempAccount = accIds.get(0);

       for (Account acc : accounts)
       {
           if (acc.getAccountID().equals(tempAccount.getAccountID()))
           {
               accounts.remove(acc);
               deleted = true;
               break;
           }
       }
       return deleted;
   }

   @Override
   public Integer insertAccount(String username, String password)
   {
       Account account = new Account();
       Integer accountId = accounts.get(accounts.size() - 1).getAccountID() + 1;
       account.setAccountID(accountId);
       account.setUsername(username);
       account.setPassword(password);
       accounts.add(account);
       return accountId;
   }

    /**
     *
     * @param username unique username entered by user when logging in
     * @return List of Account ID's that have the specified username
     */
    @Override
    public List<Account> findAccountByUsername(String username) {
        List<Account> accountList = new ArrayList<>();

        for (Account acc : accounts) {
            if(acc.getUsername().equals(username)) {
                accountList.add(acc);
            }
        }

        return accountList;
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

   @Override
    public List<Account> findAccountByUsernameAndPassword(String username, String password) {
        List<Account> accountList = new ArrayList<>();

        for (Account account : accounts) {
            if(account.getUsername().equals(username) && account.getPassword().equals(password)) {
                accountList.add(account);
            }
        }

        return accountList;
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
    public Integer insertComposition(String title, String description, Integer year, Integer isViewablePublicly, Integer accountId) {
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
    public Section findSectionFromSectionID(Integer sectionID) {
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

    @Override
    public List<Section> findSectionsByCompositionId(Integer compositionId) {
        return null;
    }

    @Override
    public List<Measure> findMeasuresBySectionId(Integer SectionId) {
        return null;
    }


}

