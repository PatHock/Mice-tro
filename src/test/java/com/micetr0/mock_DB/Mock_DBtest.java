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
        /**
        Account user = new Account();
        user.setAccountID(2);
        user.setUsername("rbosse");
        List<String> viewableComps = new ArrayList<>();
        List<String> editableComps = new ArrayList<>();
        viewableComps.add("1");
        viewableComps.add("2");
        viewableComps.add("3");
        editableComps.add("4");
        editableComps.add("5");
        editableComps.add("6");
        user.setViewableComps(viewableComps);
        user.setEditableComps(editableComps);
        **/

        List<Composition> comps = db.findCompositionsIdsByAccountId(2);

        assertTrue(comps.size() == 2);

    }

    @Test
    public void findAllAccountsTest()
    {
        List<Account> accounts = db.findAllAccounts();
        assertTrue(accounts.size() == 4);
    }

}
