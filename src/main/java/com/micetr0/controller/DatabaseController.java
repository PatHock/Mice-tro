package com.micetr0.controller;

import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;

public class DatabaseController{

    private IDatabase db;
    public DatabaseController(){
        db = DatabaseProvider.getInstance();
    }

    public void deleteDB(){
        db.deleteDB();
    }

    public void createDB() {
        db.createDB();
    }

}
