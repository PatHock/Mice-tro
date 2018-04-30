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
        Integer initialDbSize;
        Integer compositionId = 4;

        initialDbSize = db.findAllComps().size();
        assertTrue(db.deleteComposition(compositionId));

        assertEquals(initialDbSize - 1, db.findAllComps().size());

        assertFalse(db.deleteComposition(564648));
        assertEquals(initialDbSize - 1, db.findAllComps().size());

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
    void findAccountByUsernameAndPasswordTest(){

    }

    @Test
    void deleteDBTest(){
        assertEquals(6, db.findAllAccounts().size());
        db.deleteDB();
        assertEquals(0, db.findAllAccounts().size());
        db.createDB();
        assertEquals(6, db.findAllAccounts().size());
    }

    @Test
    void findCompositionsByCompositionIdTest() {
        List<Composition> compositionList;
        Composition compFergie;

        compositionList = db.findCompositionsByCompositionId(4);

        assertEquals(1, compositionList.size());
        compFergie = compositionList.get(0);

        assertEquals("Deffinicious", compFergie.getDesc());
        assertEquals((Integer) 2018, compFergie.getYear());
        assertEquals((Integer) 1, compFergie.getIsViewablePublicly());
        assertEquals((Integer) 2, compFergie.getAccountId());
        assertEquals("I Can't Think of Another Title", compFergie.getTitle());

    }

    @Test
    void updateCompositionTitleByCompositionIdTest(){
        String title;
        Composition compFergie = db.findCompositionsByCompositionId(4).get(0);
        assertEquals("I Can't Think of Another Title", compFergie.getTitle());

        title = "New Ferg, new Title";
        assertTrue(db.updateCompositionTitleByCompositionId(4, title));
        assertEquals(title, db.findCompositionsByCompositionId(4).get(0).getTitle());
    }

    @Test
    void updateCompositionYearByCompositionIdTest(){
        Composition compFergie = db.findCompositionsByCompositionId(4).get(0);

        assertTrue(db.updateCompositionYearByCompositionId(compFergie.getCompositionID(), 1985));
        assertEquals((Integer) 1985, db.findCompositionsByCompositionId(compFergie.getCompositionID()).get(0).getYear());

        assertTrue(db.updateCompositionYearByCompositionId(compFergie.getCompositionID(), 7458));
        assertEquals((Integer) 7458, db.findCompositionsByCompositionId(compFergie.getCompositionID()).get(0).getYear());
    }

    @Test
    void insertSectionTest(){
        db.insertSection(1,Defs.Key.D_MAJOR,Defs.TimeSignature.FOUR_FOUR,Defs.Clef.TREBLE, 120, 1);
        assertNotNull(db.findSection(1));
    }

    @Test
    void deleteSectionTest(){
        assertTrue(db.deleteSection(2));
    }
}
