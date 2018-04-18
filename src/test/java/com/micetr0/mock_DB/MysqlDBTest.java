package com.micetr0.mock_DB;

import com.micetr0.definitions.Defs;
import com.micetr0.model.Note;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MysqlDBTest {

    private IDatabase db;
@BeforeEach
    void setUp(){
    DatabaseProvider.setInstance(new MySqlDB());
    db = DatabaseProvider.getInstance();
}

//TODO: implement tests
}
