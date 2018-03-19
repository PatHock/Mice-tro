package com.micetr0.mock_DB;

import org.junit.Before;
import org.junit.Test;
import com.micetr0.mock_DB.*;
import static org.junit.Assert.*;

public class Mock_DBtest {

    private IDatabase db;

    @Before
    public void setUp()
    {
        InitDatabase.init(true);
        db = DatabaseProvider.getInstance();
    }

    @Test
    public void MockDBtest()
    {

    }

    @Test
    public void findNotesByMeasureIdAndMeasureIndexTest() {

        assertTrue(db.findNotesByMeasureIdAndMeasureIndex(Integer.toString(1), 1).size() == 1);
        assertTrue(db.findNotesByMeasureIdAndMeasureIndex(Integer.toString(2), 1).size() == 1);
        assertTrue(db.findNotesByMeasureIdAndMeasureIndex(Integer.toString(3), 1).size() == 1);
        assertTrue(db.findNotesByMeasureIdAndMeasureIndex(Integer.toString(4), 1).size() == 1);

        assertFalse(db.findNotesByMeasureIdAndMeasureIndex(Integer.toString(5), 1).size() > 0);

        //assertEquals();
    }


}
