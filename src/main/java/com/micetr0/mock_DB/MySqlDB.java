package com.micetr0.mock_DB;
import com.micetr0.definitions.Defs;
import com.micetr0.model.*;
//import com.sun.org.apache.xml.internal.security.Init;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlDB implements IDatabase {

    private static final int MAX_ATTEMPTS = 10;

    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            //change the database connection so that it is not a static connection.
            //Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/micetro","root","micetr0");
        }
        catch(Exception e){
            System.out.println(e);
        }
}
    protected interface Transaction<ResultType> {
        ResultType execute(Connection conn) throws SQLException;
    }

    public<ResultType> ResultType executeTransaction(Transaction<ResultType> txn) {
        try {
            return doExecuteTransaction(txn);
        } catch (SQLException e) {
            throw new PersistenceException("Transaction failed", e);
        }
    }

    public<ResultType> ResultType doExecuteTransaction(Transaction<ResultType> txn) throws SQLException {
        Connection conn = connect();

        try {
            int numAttempts = 0;
            boolean success = false;
            ResultType result = null;

            while (!success && numAttempts < MAX_ATTEMPTS) {
                try {
                    result = txn.execute(conn);
                    conn.commit();
                    success = true;
                } catch (SQLException e) {
                    if (e.getSQLState() != null && e.getSQLState().equals("41000")) {
                        // Deadlock: retry (unless max retry count has been reached)
                        numAttempts++;
                    } else {
                        // Some other kind of SQLException
                        throw e;
                    }
                }
            }

            if (!success) {
                throw new SQLException("Transaction failed (too many retries)");
            }

            // Success!
            return result;
        } finally {
            DBUtil.closeQuietly(conn);
        }
    }

    private Connection connect() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/micetro","root","micetr0");

        // Set autocommit to false to allow execution of
        // multiple queries/statements as part of the same transaction.
        conn.setAutoCommit(false);

        return conn;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Creating tables...");
        MySqlDB db = new MySqlDB();
        db.createTables();

        System.out.println("Loading initial data...");
        db.loadInitialData();

        System.out.println("Success!");
    }

    public void createTables() {
        executeTransaction(new Transaction<Boolean>() {
            public Boolean execute(Connection conn) throws SQLException {
                PreparedStatement stmt1 = null;
                PreparedStatement stmt2 = null;
                PreparedStatement stmt3 = null;
                PreparedStatement stmt4 = null;
                PreparedStatement stmt5 = null;

                try {
                    stmt1 = conn.prepareStatement(
                            "create table accounts (account_id int auto_increment primary key, " +
                                    "username varchar(40), password varchar(40), editableComps varchar(40), " +
                                    "viewableComps varchar(40));"
                    );
                    stmt1.executeUpdate();

                    stmt2 = conn.prepareStatement(
                            "create table compositions (composition_id int auto_increment primary key," +
                                    " title varchar(40), year int, description varchar(40));"
                    );
                    stmt2.executeUpdate();

                    stmt3 = conn.prepareStatement(
                            "create table sections (section_id int auto_increment primary key, " +
                                    "noteKey varchar(40), timesignature varchar(40), clef varchar(40));"
                    );
                    stmt3.executeUpdate();

                    stmt4 = conn.prepareStatement(
                            "create table measures (measure_id int auto_increment primary key, section_id int);"
                    );
                    stmt4.executeUpdate();

                    stmt5 = conn.prepareCall(
                            "create table notes (note_id int auto_increment primary key, pitch varchar(40), " +
                                    "type varchar(40), measureindex int, measure_id varchar(40));"
                    );
                    stmt5.executeUpdate();

                    return true;
                } finally {
                    DBUtil.closeQuietly(stmt1);
                    DBUtil.closeQuietly(stmt2);
                    DBUtil.closeQuietly(stmt3);
                    DBUtil.closeQuietly(stmt4);
                    DBUtil.closeQuietly(stmt5);
                }
            }
        });
    }

    public void dropTables() {
        executeTransaction(new Transaction<Boolean>() {
            public Boolean execute(Connection conn) throws SQLException {
                PreparedStatement stmt1 = null;

                try {
                    stmt1 = conn.prepareStatement(
                            "drop tables accounts, compositions, sections, notes, measures;"
                    );
                    stmt1.executeUpdate();
                    return true;
                } finally {
                    DBUtil.closeQuietly(stmt1);
                }
            }
        });
    }

    public void loadInitialData() {
        executeTransaction(new Transaction<Boolean>() {
            public Boolean execute(Connection conn) throws SQLException {
                //accountlist
                List<Account> accountList;
                //compositionlist
                List<Composition> compositionList;
                //sectionlist
                List<Section> sectionList;
                //measurelist
                List<Measure>  measureList;
                //notelist
                List<Note> noteList;
                try {
                    accountList = InitialData.getAccounts();
                    compositionList = InitialData.getCompositions();
                    sectionList = InitialData.getSections();
                    measureList = InitialData.getMeasures();
                    noteList = InitialData.getNotes();
                } catch (IOException e) {
                    throw new SQLException("Couldn't read initial data", e);
                }

                PreparedStatement insertAccount = null;
                PreparedStatement insertComposition = null;
                PreparedStatement insertSection = null;
                PreparedStatement insertMeasure = null;
                PreparedStatement insertNote = null;

                try {
                    // populate accounts table
                    insertAccount = conn.prepareStatement("insert into accounts (userAccount, passwordAccount, EditComps, viewComps) values (?, ?, ?, ?)");
                    for (Account author : accountList) {
                        //insertAccount.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
                        insertAccount.setString(1, author.getUsername());
                        insertAccount.setString(2, author.getPassword());
                        //insertAccount.setString(3, author.getEditableComps());
                        //insertAccount.setArray(4, author.getViewableComps());
                        insertAccount.addBatch();
                    }
                    insertAccount.executeBatch();

                    // populate composition table
                    insertComposition = conn.prepareStatement("insert into Composition (composition_id, title, year, description) values (?, ?, ?, ?)");
                    for (Composition composition : compositionList) {
                        //insertComposition.setInt(1, composition.getCompositionID());		// auto-generated primary key, don't insert this
                        insertComposition.setString(1, composition.getTitle());
                        insertComposition.setInt(2, composition.getYear());
                        insertComposition.setString(3, composition.getDesc());
                        insertComposition.addBatch();
                    }
                    insertComposition.executeBatch();
                    //populate section table
                    insertSection = conn.prepareStatement("insert into Section (section_id, key, timeSignature ,clef");
                    for (Section section : sectionList)
                    {
                        //insertSection.setInt(1,section.getSectionID());
                        insertSection.setString(2, section.getKey().toString());
                        insertSection.setString(3,section.getTimeSig().toString());
                        insertSection.setString(4,section.getClef().toString());
                        insertSection.addBatch();
                    }
                    insertSection.executeBatch();
                    //populate measure table
                    insertMeasure = conn.prepareStatement("insert into Measure (measure_id, section_id)");
                    for(Measure measure : measureList)
                    {
                        //insertMeasure.setInt(1,measure.getMeasureID());
                        insertMeasure.setInt(2,measure.getSectionID());
                        insertSection.addBatch();
                    }
                    insertMeasure.executeBatch();
                    //populate note table
                    insertNote = conn.prepareStatement("insert into Note (note_id, pitch, type, measureindex, measureid)");
                    for(Note note : noteList)
                    {
                       // insertNote.setInt(1, note.getNoteID());
                        insertNote.setString(2,note.getPitch().toString());
                        insertNote.setString(3,note.getType().toString());
                        insertNote.setInt(4,note.getMeasureIndex());
                        insertNote.setInt(5,note.getMeasureId());
                        insertNote.addBatch();
                    }
                    insertNote.executeBatch();
                    return true;
                } finally {
                    DBUtil.closeQuietly(insertComposition);
                    DBUtil.closeQuietly(insertAccount);
                }
            }
        });
    }


    /////////////////////////////////////////////DataBaseMethods/////////////////////////////////////////


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

    @Override
    public void deleteDB() {
        dropTables();
    }

    @Override
    public void createDB() {
        createTables();
    }
}
