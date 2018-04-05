package com.micetr0.mock_DB;

import com.micetr0.definitions.Defs;
import com.micetr0.model.Account;
import com.micetr0.model.Composition;
import org.junit.Before;
import org.junit.Test;
import com.micetr0.mock_DB.*;

import static com.micetr0.mock_DB.Mock_DB.*;
import static org.junit.Assert.*;
import com.micetr0.model.Note;
import com.micetr0.definitions.Defs;

import java.util.ArrayList;
import java.util.List;

public class Mock_DBtest {

    private IDatabase db;

    @Before
    public void setUp()
    {
        InitDatabase.init(true);
        db = DatabaseProvider.getInstance();
    }


    @Test
    public void findNotesByMeasureIdAndMeasureIndexTest() {

        assertTrue(db.findNotesByMeasureIdAndMeasureIndex(1, 1).size() == 1);
        assertTrue(db.findNotesByMeasureIdAndMeasureIndex(2, 1).size() == 1);
        assertTrue(db.findNotesByMeasureIdAndMeasureIndex(3, 1).size() == 1);
        assertTrue(db.findNotesByMeasureIdAndMeasureIndex(4, 1).size() == 1);

        assertFalse(db.findNotesByMeasureIdAndMeasureIndex(5, 1).size() > 0);

        //assertEquals();
    }

    @Test
    public void insertNoteTest() {
        Defs.Pitch pitch =  Defs.Pitch.F8_SHARP;
        Defs.NoteType noteType = Defs.NoteType.EIGHTH;
        Integer measureId = 7;
        Integer measureIndex = 3;


        Note note = new Note(1, noteType, pitch, measureIndex, measureId);
        db.insertNote(note);

        assertTrue(db.findNotesByMeasureIdAndMeasureIndex(7, 3).get(0).getPitch().equals(pitch));
    }

    @Test
    public void findCompositionsIdsByAccountIdTest()
    {

        List<Composition> comps = db.findCompositionsIdsByAccountId(2);

        assertTrue(comps.size() == 2);

    }

    @Test
    public void findCurrentAccountTest()
    {
        List<Account> Account = db.findCurrentAccount(1);
        assertTrue(Account.get(0).getUsername().equals("sad_Keanu"));
    }

    @Test
    public void findAllAccountsTest()
    {
        List<Account> accounts = db.findAllAccounts();
        assertTrue(accounts.size() == 4);
    }

    @Test
    public void deleteCompositionTest()
    {
        Integer compositionId = 4;
        db.deleteComposition(compositionId);

        List<Composition> comps = db.findAllComps();
        assertTrue(comps.size() == 4);
        assertTrue(comps.get(comps.size()-1).getTitle().equals("Hump De Bump"));
    }

    @Test
    public void findAllCompsTest()
    {
        List<Composition> allComps = db.findAllComps();

        assertTrue(allComps.size() == 5);
    }

    @Test
    public void insertAccountTest()
    {
        Account newUser = new Account();
        newUser.setUsername("Morty_Ruelz");
        newUser.setPassword("Rick_Sux");
        db.insertAccount(newUser);

        List<Account> accnts = db.findAllAccounts();

        assertTrue(accnts.size() == 5);
        assertTrue(accnts.get(accnts.size()-1).getUsername().equals("Morty_Ruelz"));
    }

}
