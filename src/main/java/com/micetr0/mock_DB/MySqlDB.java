package com.micetr0.mock_DB;
import com.micetr0.model.Account;
import com.micetr0.model.Composition;
import com.micetr0.model.Note;

import java.sql.*;
import javax.naming.spi.DirStateFactory.Result;
import java.util.List;

public class MySqlDB implements IDatabase {
    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/micetro","root","micetr0");
        }
        catch(Exception e){
            System.out.println(e);
        }
}
    @Override
    public void insertNote(Note note) {
    }

    @Override
    public void deleteNote(String noteId) {
    }

    @Override
    public List<Note> findNotesByMeasureIdAndMeasureIndex(Integer measureId, Integer measureIndex) {
        return null;
    }

    @Override
    public List<Composition> findCompositionsIdsByAccountId(Integer accountId) {
        return null;
    }

    @Override
    public List<Account> findAllAccounts() {
        return null;
    }

    @Override
    public List<Account> findCurrentAccount(Integer accountId) {
        return null;
    }

    @Override
    public void insertComposition(Composition composition) {

    }

    @Override
    public void deleteComposition(Integer compositionId) {

    }

    @Override
    public void deleteAccount(String username) {

    }

    @Override
    public List<Composition> findAllComps() {
        return null;
    }

    @Override
    public void insertAccount(Account account) {


    }

    @Override
    public List<Integer> findAccountIdByUsername(String username) {
        return null;
    }

    @Override
    public List<Integer> findAccountIdByUsernameAndPassword(String username, String password) {
        return null;
    }
}
