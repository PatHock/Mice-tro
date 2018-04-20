package com.micetr0.mock_DB;

import com.micetr0.definitions.Defs;
import com.micetr0.model.Account;
import com.micetr0.model.Composition;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.micetr0.model.Note;

import java.util.ArrayList;
import java.util.List;

class Mock_DBtest {

    private IDatabase db;

    @BeforeEach
    void setUp()
    {
        DatabaseProvider.setInstance(new Mock_DB());
        db = DatabaseProvider.getInstance();
    }


    @Test
    void findNotesByMeasureIdAndMeasureIndexTest() {

        assertEquals(1, db.findNotesByMeasureIdAndMeasureIndex(1, 1).size());
        assertEquals(1, db.findNotesByMeasureIdAndMeasureIndex(2, 1).size());
        assertEquals(1, db.findNotesByMeasureIdAndMeasureIndex(3, 1).size());
        assertEquals(1, db.findNotesByMeasureIdAndMeasureIndex(4, 1).size());

        assertFalse(db.findNotesByMeasureIdAndMeasureIndex(5, 1).size() > 0);
    }


    @Test
    void insertNoteTest() {
        Defs.Pitch pitch =  Defs.Pitch.F8_SHARP;
        Defs.NoteType noteType = Defs.NoteType.EIGHTH;
        Integer measureId = 7;
        Integer measureIndex = 3;

        Note note = new Note(1, noteType, pitch, measureIndex, measureId);
        db.insertNote(noteType.toString(),pitch.toString(),measureIndex,measureId);

        assertEquals(db.findNotesByMeasureIdAndMeasureIndex(7, 3).get(0).getPitch(), pitch);
    }
/*
    @Test
    void findAccountByAccountIDTest()
    {
        List<Account> Account = db.findAccountByAccountID(1);
        assertEquals("sad_Keanu", Account.get(0).getUsername());
    }

    @Test
    void findAccountByUsernameTest(){

    }
*/
    @Test
    void findAllAccountsTest()
    {
        List<Account> accounts = db.findAllAccounts();
        assertEquals(6, accounts.size());
    }

    @Test
    void deleteCompositionTest()
    {
        Integer compositionId = 4;
        db.deleteComposition(compositionId);

        List<Composition> comps = db.findAllComps();
        assertEquals(4, comps.size());
        assertEquals("Hump De Bump", comps.get(comps.size() - 1).getTitle());
    }

    @Test
    void findAllCompsTest()
    {
        List<Composition> allComps = db.findAllComps();

        assertEquals(5, allComps.size());
    }

    @Test
    void insertAccountTest()
    {
        List<Account> accnts = db.findAllAccounts();

        String username = "Morty_Ruelz";
        String password = "Rick_Sux";
        db.insertAccount(username, password);

        List<Account> addedAccnts = db.findAllAccounts();

        assertEquals(accnts.size() + 1, addedAccnts.size());
        assertEquals("Morty_Ruelz", addedAccnts.get(addedAccnts.size() - 1).getUsername());
    }

    @Test
    void findAccountIdByUsernameAndPasswordTest() {
        // See if the test can find sad Keanu
        assertEquals(1, (int) db.findAccountIdByUsernameAndPassword("sad_Keanu", "sad_Keanu_is_Sad").get(0));
        assertEquals(db.findAccountIdByUsernameAndPassword("sad_Keanu", "sad_Keanu_is_Sad").size(), 1);

        // Try checking for valid username but invalid password
        assertEquals(db.findAccountIdByUsernameAndPassword("sad_Keanu", "sad_Keanu").size(), 0);

        // See if peppe is ok
        assertEquals(2, (int) db.findAccountIdByUsernameAndPassword("peppe", "peppeDaFrog").get(0));
        assertEquals(1, db.findAccountIdByUsernameAndPassword("peppe", "peppeDaFrog").size());

    }

    @Test
    void deleteDBTest(){
        assertTrue(db.findAllAccounts().size() == 6);
        db.deleteDB();
        assertTrue(db.findAllAccounts().size() == 0);
        db.createDB();
        assertTrue(db.findAllAccounts().size() == 6);
    }
}
