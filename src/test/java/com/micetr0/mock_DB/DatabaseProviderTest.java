package com.micetr0.mock_DB;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseProviderTest {
    private IDatabase db = new Mock_DB();

    @BeforeEach
    void setUp() {

    }

    @Test
    void setInstance() {
        // needed in order to have assertThrows method fail
        DatabaseProvider.setInstance(null);
        //noinspection ResultOfMethodCallIgnored
        assertThrows(IllegalStateException.class, DatabaseProvider::getInstance);

        DatabaseProvider.setInstance(db);
        assertEquals(DatabaseProvider.getInstance(), db);
    }

}