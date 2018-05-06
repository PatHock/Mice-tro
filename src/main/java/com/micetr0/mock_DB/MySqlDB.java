package com.micetr0.mock_DB;
import com.micetr0.definitions.Defs;
import com.micetr0.model.*;
//import com.sun.org.apache.xml.internal.security.Init;

import javax.xml.transform.Result;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySqlDB implements IDatabase {

    private static final int MAX_ATTEMPTS = 10;

    static{
        try{
            Class.forName("com.mysql.jdbc.Driver");
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
        //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/micetro","root","Angelofmusic01");
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
                            "create table accounts (account_id int auto_increment primary key," +
                                    " username varchar(40), password varchar(40))"
                    );
                    stmt1.executeUpdate();

                    stmt2 = conn.prepareStatement(
                            "create table compositions (composition_id int auto_increment primary key, " +
                                    "title varchar(40), year int, description varchar(40), " +
                                    "account_id int references account(account_id), viewableComp int)"
                    );
                    stmt2.executeUpdate();

                    stmt3 = conn.prepareStatement(
                            "create table sections (section_id int auto_increment primary key, " +
                                    "noteKey varchar(40), timesignature varchar(40), clef varchar(40), tempo int, " +
                                    "composition_id int references compositions(composition_id))"
                    );
                    stmt3.executeUpdate();

                    stmt4 = conn.prepareStatement(
                            "create table measures (measure_id int auto_increment primary key, " +
                                    "section_id int references sections(section_id))"
                    );
                    stmt4.executeUpdate();

                    stmt5 = conn.prepareCall(
                            "create table notes (note_id int auto_increment primary key, pitch varchar(40), " +
                                    "noteType varchar(40), measureindex int, measure_id int references measures(measure_id))"
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
    @Override
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
                    insertAccount = conn.prepareStatement("insert into accounts (userName, password) values (?, ?)");
                    for (Account author : accountList) {
                        //insertAccount.setInt(1, author.getAuthorId());	// auto-generated primary key, don't insert this
                        insertAccount.setString(1, author.getUsername());
                        insertAccount.setString(2, author.getPassword());
                        insertAccount.addBatch();
                    }
                    insertAccount.executeBatch();

                    // populate composition table
                    insertComposition = conn.prepareStatement("insert into compositions (title, year, description, account_id, viewableComp) values (?, ?, ?, ?, ?)");
                    for (Composition composition : compositionList) {
                        //insertComposition.setInt(1, composition.getCompositionID());		// auto-generated primary key, don't insert this
                        insertComposition.setString(1, composition.getTitle());
                        insertComposition.setInt(2, composition.getYear());
                        insertComposition.setString(3, composition.getDesc());
                        insertComposition.setInt(4,composition.getAccountId());
                        insertComposition.setInt(5,composition.getIsViewablePublicly());
                        insertComposition.addBatch();
                    }
                    insertComposition.executeBatch();
                    //populate section table
                    insertSection = conn.prepareStatement("insert into sections (noteKey, timeSignature, clef, tempo, composition_id) values (?, ?, ?, ?, ?)");
                    for (Section section : sectionList)
                    {
                        //insertSection.setInt(1,section.getSectionID());
                        insertSection.setString(1, section.getKey().toString());
                        insertSection.setString(2, section.getTimeSig().toString());
                        insertSection.setString(3, section.getClef().toString());
                        insertSection.setInt(4, section.getTempo());
                        insertSection.setInt(5, section.getCompID());
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
                    insertNote = conn.prepareStatement("insert into notes (pitch, noteType, measureindex, measure_id) values (?, ?, ?, ?)");
                    for(Note note : noteList)
                    {
                       // insertNote.setInt(1, note.getNoteID());
                        insertNote.setString(1,note.getPitch().toString());
                        insertNote.setString(2,note.getType().toString());
                        insertNote.setInt(3,note.getMeasureIndex());
                        insertNote.setInt(4,note.getMeasureId());
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
    public Integer insertNote(String type, String pitch, Integer measureIndex, Integer measureId) {
        return executeTransaction(conn -> {
            PreparedStatement addNoteStmt = null;
            PreparedStatement getNoteIdStmt = null;
            ResultSet addedNotesResult = null;
            Integer noteId = -1;

            try{
                addNoteStmt = conn.prepareStatement(
                        "insert into notes (pitch, noteType, measureIndex, measure_id) values (?,?,?,?)"
                );
                addNoteStmt.setString(1, pitch);
                addNoteStmt.setString(2,type);
                addNoteStmt.setInt(3,measureIndex);
                addNoteStmt.setInt(4,measureId);

                addNoteStmt.executeUpdate();

                //Get updated note Id

                getNoteIdStmt = conn.prepareStatement(
                        "select notes.* from notes "+
                                "where pitch = ? and noteType = ? and measureIndex = ? and measure_id = ?"
                );

                getNoteIdStmt.setString(1,pitch);
                getNoteIdStmt.setString(2,type);
                getNoteIdStmt.setInt(3,measureIndex);
                getNoteIdStmt.setInt(4,measureId);

                addedNotesResult = getNoteIdStmt.executeQuery();

                boolean found = false;

                while(addedNotesResult.next()){
                    found = true;
                    noteId = addedNotesResult.getInt(1);
                }

                if(!found){
                    System.out.println("Note was not added correctly, something went wrong");
                }

                return noteId;
            }
            finally{
                DBUtil.closeQuietly(addNoteStmt);
                DBUtil.closeQuietly(getNoteIdStmt);
                DBUtil.closeQuietly(addedNotesResult);
            }
        });
    }

    @Override
    public Boolean deleteNote(Integer noteId) {
        return executeTransaction(conn -> {
            PreparedStatement removeNoteStmt = null;
            PreparedStatement checkStmt = null;
            ResultSet allNotes = null;
            //boolean for final result
            boolean foundDeletedNote = false;
            Boolean deleted = false;

            try{
                removeNoteStmt = conn.prepareStatement(
                        "delete from notes where note_id = ?"
                );
                removeNoteStmt.setInt(1,noteId);

                removeNoteStmt.executeUpdate();

                checkStmt = conn.prepareStatement(
                        "select notes.* from notes"
                );

                allNotes = checkStmt.executeQuery();

                //this better be true cause we need some notes
                boolean found = false;

                while(allNotes.next()){
                    found = true;
                    if(allNotes.getInt(1) == noteId){
                        //failed, note not deleted
                        System.out.println("Note with same ID found after deleted, something went wrong");
                        foundDeletedNote = true;
                    }

                }
                if(found == true && foundDeletedNote == false){
                    deleted = true;
                }

                return deleted;
            }
            finally{
                DBUtil.closeQuietly(removeNoteStmt);
                DBUtil.closeQuietly(checkStmt);
                DBUtil.closeQuietly(allNotes);
            }
        });
    }

    @Override
    public List<Composition> findCompositionsByAccountId(Integer accountId) {
        return executeTransaction(conn -> {
            PreparedStatement getCompsStmt = null;
            ResultSet compsResultSet = null;

            try{
                getCompsStmt = conn.prepareStatement(
                        "select * from compositions where account_id = ?"
                );
                getCompsStmt.setInt(1,accountId);

                List<Composition> comps = new ArrayList<>();

                compsResultSet = getCompsStmt.executeQuery();
                System.out.println(comps);

                boolean found = false;

                while(compsResultSet.next()){
                    found = true;

                    Composition comp = new Composition();
                    loadComposition(comp,compsResultSet,1);
                    comps.add(comp);
                }

                if(!found){
                    System.out.println("No compositions exist for that Account ID");
                }

                return comps;
            }
            finally{
                DBUtil.closeQuietly(getCompsStmt);
                DBUtil.closeQuietly(compsResultSet);
            }
        });
    }

    @Override
    public List<Note> findNotesByMeasureIdAndMeasureIndex(Integer measureId, Integer measureIndex) {
        return executeTransaction(conn -> {
            PreparedStatement getNotesStmt = null;
            ResultSet noteResultSet = null;

            try{
                getNotesStmt = conn.prepareStatement(
                        "select notes.* from notes where measure_id = ? and measureIndex = ?"
                );
                getNotesStmt.setInt(1,measureId);
                getNotesStmt.setInt(2,measureIndex);

                List<Note> result = new ArrayList<>();

                noteResultSet = getNotesStmt.executeQuery();

                while(noteResultSet.next()){
                    Integer noteID = noteResultSet.getInt(1);
                    String pitch = noteResultSet.getString(2);

                    String type = noteResultSet.getString(3);
                    Integer measureIndx = noteResultSet.getInt(4);
                    Integer measureID = noteResultSet.getInt(5);

                    Note note = new Note(noteID, Defs.NoteType.valueOf(type), Defs.Pitch.valueOf(pitch), measureIndx, measureID);

                    result.add(note);
                }
                return result;
            }
            finally {
                DBUtil.closeQuietly(getNotesStmt);
                DBUtil.closeQuietly(noteResultSet);
            }
        });
    }

    @Override
    public List<Account> findAllAccounts() {
        return executeTransaction(conn -> {
            PreparedStatement getAccsStmt = null;
            ResultSet accResultSet = null;

            try{
                getAccsStmt = conn.prepareStatement(
                    "Select accounts.* from accounts"
                );

                List<Account> resultAccounts = new ArrayList<Account>();

                accResultSet = getAccsStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

                while(accResultSet.next()){
                    found = true;

                    Account account = new Account();
                    loadAccount(account, accResultSet, 1);

                    resultAccounts.add(account);
                }

                if(!found){
                    System.out.println("No Account was found that matched that username");
                }

                return resultAccounts;
            }
            finally{
                DBUtil.closeQuietly(getAccsStmt);
                DBUtil.closeQuietly(accResultSet);
            }
        });
    }

    @Override
    public List<Account> findAccountByAccountID(Integer accountId) {
        return executeTransaction(conn -> {
            PreparedStatement getAccStmt = null;
            ResultSet accResultSet = null;

            try{
                getAccStmt = conn.prepareStatement(
                        "Select accounts.* from accounts "+
                                "where account_id = ?"
                );
                getAccStmt.setInt(1,accountId);

                List<Account> resultAccounts = new ArrayList<>();

                accResultSet = getAccStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

                while(accResultSet.next()){
                    found = true;

                    Account account = new Account();
                    loadAccount(account, accResultSet, 1);

                    resultAccounts.add(account);
                }

                if(!found){
                    System.out.println("No Account was found that matched that Account ID");
                }

                return resultAccounts;
            }
            finally{
                DBUtil.closeQuietly(getAccStmt);
                DBUtil.closeQuietly(accResultSet);
            }
        });
    }

    @Override
    public Boolean deleteComposition(Integer compositionId) {
        return executeTransaction((Connection conn) -> {
            PreparedStatement removeCompStmt = null;
            PreparedStatement checkStmt = null;
            ResultSet checkSet = null;
            //boolean for final result
            boolean foundDeletedNote = false;
            Boolean deleted = false;

            try{
                removeCompStmt = conn.prepareStatement(
                        "delete from compositions where composition_id = ?"
                );
                removeCompStmt.setInt(1,compositionId);

                removeCompStmt.executeUpdate();

                //Check to see if any compositions have the deleted ID
                checkStmt = conn.prepareStatement(
                        "select composititons.* from compositions where composition_id = ?"
                );
                checkStmt.setInt(1, compositionId);
                checkSet = checkStmt.executeQuery();

                while(checkSet.next()){
                    foundDeletedNote = true;
                    System.out.println("Comp not deleted, ID = " + checkSet.getInt(1));
                }

                if(!foundDeletedNote){
                    deleted = true;
                }
                return deleted;
            }
            finally{
                DBUtil.closeQuietly(removeCompStmt);
                DBUtil.closeQuietly(checkStmt);
                DBUtil.closeQuietly(checkSet);
            }
        });
    }

    @Override
    public Boolean deleteAccount(String username) {
        return executeTransaction((Connection conn) -> {
            PreparedStatement removeAcctStmt = null;
            PreparedStatement checkStmt = null;
            ResultSet checkSet = null;
            boolean foundDeletedAccount = false;
            Boolean deleted = false;

            try{
                removeAcctStmt = conn.prepareStatement(
                        "delete from accounts where username = ?"
                );
                removeAcctStmt.setString(1,username);
                removeAcctStmt.executeUpdate();

                //check to see if account was removed. If resultset comes back empty, good to go
                checkStmt = conn.prepareStatement(
                        "select accounts.* from accounts where username = ?"
                );
                checkStmt.setString(1,username);
                checkSet = checkStmt.executeQuery();

                while(checkSet.next()){
                    foundDeletedAccount = true;
                    System.out.println("Account not deleted, ID = " + checkSet.getInt(1) + "Username = " +checkSet.getString(2));

                }
                if(!foundDeletedAccount){
                    deleted = true;
                }
                return deleted;
            }
            finally{
                DBUtil.closeQuietly(removeAcctStmt);
                DBUtil.closeQuietly(checkStmt);
                DBUtil.closeQuietly(checkSet);
            }
        });
    }

    @Override
    public List<Composition> findAllComps() {
        return executeTransaction((Connection conn) -> {
            PreparedStatement getCompsStmt = null;
            ResultSet compResultSet = null;

            try{
                getCompsStmt = conn.prepareStatement(
                        "select * from compositions"
                );

                List<Composition> resultComps = new ArrayList<>();
                compResultSet = getCompsStmt.executeQuery();
                boolean found = false;

                while(compResultSet.next()){
                    found = true;
                    Composition comp = new Composition();
                    loadComposition(comp,compResultSet,1);
                    resultComps.add(comp);
                }

                if(!found){
                    System.out.println("No Compositions found in database, like at all. No bueno");
                }

                return resultComps;
            }
            finally{
                DBUtil.closeQuietly(getCompsStmt);
                DBUtil.closeQuietly(compResultSet);
            }
        });
    }

    @Override
    public Integer insertAccount(String username, String password) {
        return executeTransaction((Connection conn) -> {
            PreparedStatement instAccStmt = null;
            PreparedStatement getAccIDStmt = null;
            ResultSet accResultSet = null;

            try{
                instAccStmt = conn.prepareStatement(
                        "insert into accounts (username, password) " +
                                "values(?, ?) "
                );
                instAccStmt.setString(1,username);
                instAccStmt.setString(2,password);

                instAccStmt.executeUpdate();

                System.out.println(username + " has been added to database");

                getAccIDStmt = conn.prepareStatement(
                        "select accounts.* from accounts "+
                                "where username = ? and password = ?"
                );
                getAccIDStmt.setString(1,username);
                getAccIDStmt.setString(2,password);

                List<Account> resultAccounts = new ArrayList<Account>();

                accResultSet = getAccIDStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

                Integer accountID = 0;

                while(accResultSet.next()){
                    found = true;

                    Account account = new Account();
                    loadAccount(account, accResultSet, 1);
                    accountID = account.getAccountID();

                    resultAccounts.add(account);
                }

                if(!found){
                    System.out.println("Account was not added successfully");
                }

                return accountID;
            }
            finally{
                DBUtil.closeQuietly(instAccStmt);
                DBUtil.closeQuietly(getAccIDStmt);
                DBUtil.closeQuietly(accResultSet);
            }
        });
    }

    @Override
    public List<Account> findAccountByUsername(String username) {
        return executeTransaction(conn -> {
            PreparedStatement getAccStmt = null;
            ResultSet accResultSet = null;

            try{
                getAccStmt = conn.prepareStatement(
                        "Select accounts.* from accounts "+
                                "where username = ?"
                );
                getAccStmt.setString(1,username);

                List<Account> resultAccounts = new ArrayList<>();

                accResultSet = getAccStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

                while(accResultSet.next()){
                    found = true;

                    Account account = new Account();
                    loadAccount(account, accResultSet, 1);

                    resultAccounts.add(account);
                }

                if(!found){
                    System.out.println("No Account was found that matched that username");
                }

                return resultAccounts;
            }
            finally{
                DBUtil.closeQuietly(getAccStmt);
                DBUtil.closeQuietly(accResultSet);
            }
        });
    }


    /**
     * @param compositionId Unique database-specific identification for a composition
     * @param description   A user-editable description for the composition
     * @return Boolean isCompUpdated: True when update operation is successful, false otherwise
     */
    @Override
    public Boolean updateCompositionDescriptionByCompositionId(Integer compositionId, String description) {
        return executeTransaction((Connection conn) -> {
            PreparedStatement updateCompStmt = null;
            PreparedStatement checkStmt = null;
            ResultSet checkSet = null;

            Boolean newDescFound = false;
            Boolean successfulUpdate = false;

            try {
                updateCompStmt = conn.prepareStatement(
                        "update compositions set description = ? where composition_id = ?"
                );
                updateCompStmt.setString(1, description);
                updateCompStmt.setInt(2, compositionId);

                updateCompStmt.executeUpdate();

                checkStmt = conn.prepareStatement(
                        "select compositions.* from compositions where composition_id = ?"
                );
                checkStmt.setInt(1, compositionId);

                checkSet = checkStmt.executeQuery();

                Integer count = 0;

                while (checkSet.next()) {
                    count++;
                    if (checkSet.getString(4).equals(description)) {
                        newDescFound = true;
                    }
                }
                //make sure only 1 result found
                if (count < 2 && newDescFound == true) {
                    successfulUpdate = true;
                }

                return successfulUpdate;
            }
            finally {
                DBUtil.closeQuietly(updateCompStmt);
                DBUtil.closeQuietly(checkStmt);
                DBUtil.closeQuietly(checkSet);
            }
        });
    }

    /**
     * @param compositionId Unique Identifier for compositions.
     * @param title         The title of a composition. Editable by the user.
     * @return Boolean isCompUpdated: True when update operation is successful, false otherwise
     */
    @Override
    public Boolean updateCompositionTitleByCompositionId(Integer compositionId, String title) {
        return executeTransaction((Connection conn) -> {
            PreparedStatement updateCompStmt = null;
            PreparedStatement checkStmt = null;
            ResultSet checkSet = null;

            Boolean newTitleFound = false;
            Boolean successfulUpdate = false;

            try {
                updateCompStmt = conn.prepareStatement(
                        "update compositions set title = ? where composition_id = ?"
                );
                updateCompStmt.setString(1, title);
                updateCompStmt.setInt(2, compositionId);

                updateCompStmt.executeUpdate();

                checkStmt = conn.prepareStatement(
                        "select compositions.* from compositions where composition_id = ?"
                );
                checkStmt.setInt(1, compositionId);

                checkSet = checkStmt.executeQuery();

                Integer count = 0;

                while (checkSet.next()) {
                    count++;
                    if (checkSet.getString(2).equals(title)) {
                        newTitleFound = true;
                    }
                }
                //make sure only 1 result found
                if (count < 2 && newTitleFound == true) {
                    successfulUpdate = true;
                }

                return successfulUpdate;
            }
            finally {
                DBUtil.closeQuietly(updateCompStmt);
                DBUtil.closeQuietly(checkStmt);
                DBUtil.closeQuietly(checkSet);
            }
        });
    }

    @Override
    public List<Account> findAccountByUsernameAndPassword(String username, String password) {
        return executeTransaction((Connection conn) -> {
            PreparedStatement getAcctStmt = null;
            ResultSet accResultSet = null;

            try{
                getAcctStmt = conn.prepareStatement(
                        "select accounts.* from accounts where username = ? and password = ?"
                );
                getAcctStmt.setString(1, username);
                getAcctStmt.setString(2, password);

                List<Account> resultAccounts = new ArrayList<>();

                accResultSet = getAcctStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

                while(accResultSet.next()){
                    found = true;

                    Account account = new Account();
                    loadAccount(account, accResultSet, 1);

                    resultAccounts.add(account);
                }

                if(!found){
                    System.out.println("No Account was found that matched that username and password");
                }

                return resultAccounts;
            }
            finally{
                DBUtil.closeQuietly(getAcctStmt);
                DBUtil.closeQuietly(accResultSet);
            }
        });
    }

    /**
     * @param compositionId Unique ID that distinguishes a composition from others in the database.
     * @return an ArrayList of Composition objects that match the given composition ID
     */
    @Override
    public List<Composition> findCompositionsByCompositionId(Integer compositionId) {
        return executeTransaction(conn -> {
            PreparedStatement getCompsStmt = null;
            ResultSet compsResultSet = null;

            try{
                getCompsStmt = conn.prepareStatement(
                        "select compositions.* from compositions where composition_id = ?"
                );
                getCompsStmt.setInt(1,compositionId);

                List<Composition> comps = new ArrayList<>();

                compsResultSet = getCompsStmt.executeQuery();

                boolean found = false;

                while(compsResultSet.next()){
                    found = true;

                    Composition comp = new Composition();
                    loadComposition(comp,compsResultSet,1);
                    comps.add(comp);
                }

                if(!found){
                    System.out.println("No compositions exist for that comp ID");
                }

                return comps;
            }
            finally{
                DBUtil.closeQuietly(getCompsStmt);
                DBUtil.closeQuietly(compsResultSet);
            }
        });
    }

    /**
     * @param compositionId Unique Identifier for compositions.
     * @param year          Integer year when the composition was written
     * @return Boolean, true indicates that update was successful, false indicates that update failed (invalid composition ID)
     */
    @Override
    public Boolean updateCompositionYearByCompositionId(Integer compositionId, Integer year) {
        return executeTransaction((Connection conn) -> {
            PreparedStatement updateCompStmt = null;
            PreparedStatement checkStmt = null;
            ResultSet checkSet = null;

            Boolean newYearFound = false;
            Boolean successfulUpdate = false;

            try {
                updateCompStmt = conn.prepareStatement(
                        "update compositions set year = ? where composition_id = ?"
                );
                updateCompStmt.setInt(1, year);
                updateCompStmt.setInt(2, compositionId);

                updateCompStmt.executeUpdate();

                checkStmt = conn.prepareStatement(
                        "select compositions.* from compositions where composition_id = ?"
                );
                checkStmt.setInt(1, compositionId);

                checkSet = checkStmt.executeQuery();

                Integer count = 0;

                while (checkSet.next()) {
                    count++;
                    if (checkSet.getInt(3) == year) {
                        newYearFound = true;
                    }
                }
                //make sure only 1 result found
                if (count < 2 && newYearFound == true) {
                    successfulUpdate = true;
                }
                return successfulUpdate;
            }
            finally {
                DBUtil.closeQuietly(updateCompStmt);
                DBUtil.closeQuietly(checkStmt);
                DBUtil.closeQuietly(checkSet);
            }
        });
    }

    /**
     * Creates a composition from given title, description, and year. Generates unique ID
     *
     * @param title              The name of the composition.
     * @param description        A string that describes the purpose etc of the composition
     * @param year               The year the composition was written
     * @param isViewablePublicly
     * @param accountId
     * @return A composition object with unique ID
     */
    @Override
    public Integer insertComposition(String title, String description, Integer year, Integer accountId, Integer isViewablePublicly) {
        return executeTransaction((Connection conn) -> {
            PreparedStatement instCompStmt = null;
            PreparedStatement getCompIDStmt = null;
            ResultSet compResultSet = null;

            try{
                instCompStmt = conn.prepareStatement(
                        "insert into compositions (title, year, description, account_id, viewableComp) " +
                                "values(?, ?, ?, ?, ?) "
                );
                instCompStmt.setString(1,title);
                instCompStmt.setInt(2,year);
                instCompStmt.setString(3,description);
                instCompStmt.setInt(4,accountId);
                instCompStmt.setInt(5,isViewablePublicly);

                instCompStmt.executeUpdate();

                System.out.println(title + "has been added to database");

                getCompIDStmt = conn.prepareStatement(
                        "select * from compositions "+
                                "where title = ? and year = ? and description = ? and account_id = ? and viewableComp = ?"
                );
                getCompIDStmt.setString(1,title);
                getCompIDStmt.setInt(2,year);
                getCompIDStmt.setString(3,description);
                getCompIDStmt.setInt(4,accountId);
                getCompIDStmt.setInt(5,isViewablePublicly);

                List<Composition> resultCompositions = new ArrayList<>();

                compResultSet = getCompIDStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

                Integer compID = -1;

                while(compResultSet.next()){
                    found = true;

                    Composition comp = new Composition();
                    loadComposition(comp, compResultSet, 1);
                    compID = comp.getCompositionID();

                    resultCompositions.add(comp);
                }

                if(!found){
                    System.out.println("Composition was not added successfully");
                }

                return compID;
            }
            finally{
                DBUtil.closeQuietly(instCompStmt);
                DBUtil.closeQuietly(getCompIDStmt);
                DBUtil.closeQuietly(compResultSet);
            }
        });
    }

    /**
     * Finds notes by measure id ... Pretty Self explanatory
     *
     * @param measureId unique ID of a measure
     * @return Note object
     */
    @Override
    public List<Note> findNotesByMeasureId(Integer measureId) {
        return null;
    }

    /**
     * Find all of the notes in a composition.
     *
     * @param compositionId unique ID of a composition
     * @return list of note objects contained in a composition
     */
    @Override
    public List<Note> findNotesByCompositionId(Integer compositionId) {
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

    @Override
    public Integer insertSection(Defs.Key key, Defs.TimeSignature timeSig, Defs.Clef clef, Integer tempo, Integer composition_ID) {
        return executeTransaction((Connection conn) -> {
            PreparedStatement instSectStmt = null;
            PreparedStatement getSectIDStmt = null;
            ResultSet sectResultSet = null;

            try{
                instSectStmt = conn.prepareStatement(
                        "insert into sections (noteKey, timesignature, clef, tempo, composition_id) " +
                                "values(?, ?, ?, ?, ?) "
                );
                instSectStmt.setString(1, key.toString());
                instSectStmt.setString(2, timeSig.toString());
                instSectStmt.setString(3, clef.toString());
                instSectStmt.setInt(4, tempo);
                instSectStmt.setInt(5, composition_ID);

                instSectStmt.executeUpdate();

                getSectIDStmt = conn.prepareStatement(
                        "select sections.* from sections "+
                                "where noteKey = ? and timesignature = ? and clef = ? and tempo = ? and composition_id = ?"
                );
                getSectIDStmt.setString(1, key.toString());
                getSectIDStmt.setString(2, timeSig.toString());
                getSectIDStmt.setString(3, clef.toString());
                getSectIDStmt.setInt(4, tempo);
                getSectIDStmt.setInt(5, composition_ID);

                List<Section> resultSections = new ArrayList<>();

                sectResultSet = getSectIDStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

                Integer sectID = -1;

                while(sectResultSet.next()){
                    found = true;

                    Section section = new Section();
                    loadSection(section,sectResultSet,1);
                    sectID = section.getSectionID();

                    resultSections.add(section);
                }

                if(!found){
                    System.out.println("section was not added successfully");
                }

                return sectID;
            }
            finally{
                DBUtil.closeQuietly(instSectStmt);
                DBUtil.closeQuietly(getSectIDStmt);
                DBUtil.closeQuietly(sectResultSet);
            }
        });
    }

    @Override
    public Boolean deleteSection(Integer sectionID) {
        return executeTransaction((Connection conn) -> {
            PreparedStatement removeSectStmt = null;
            PreparedStatement checkStmt = null;
            ResultSet checkSet = null;
            boolean foundDeletedSect = false;
            Boolean deleted = false;

            try{
                removeSectStmt = conn.prepareStatement(
                        "delete from sections where section_id = ?"
                );
                removeSectStmt.setInt(1,sectionID);

                removeSectStmt.executeUpdate();

                //check to see if account was removed. If resultset comes back empty, good to go
                checkStmt = conn.prepareStatement(
                        "select sections.* from sections where section_id = ?"
                );
                checkStmt.setInt(1,sectionID);
                checkSet = checkStmt.executeQuery();

                while(checkSet.next()){
                    foundDeletedSect = true;
                    System.out.println("Account not deleted, ID = " + checkSet.getInt(1) + "Username = " +checkSet.getString(2));

                }
                if(!foundDeletedSect){
                    deleted = true;
                }
                return deleted;
            }
            finally{
                DBUtil.closeQuietly(removeSectStmt);
                DBUtil.closeQuietly(checkStmt);
                DBUtil.closeQuietly(checkSet);
            }
        });
    }

    @Override
    public List<Section> findSectionFromSectionID(Integer sectionID) {
        return executeTransaction(conn -> {
            PreparedStatement getSectStmt = null;
            ResultSet sectResultSet = null;

            try{
                getSectStmt = conn.prepareStatement(
                        "Select sections.* from sections "+
                                "where section_id = ?"
                );
                getSectStmt.setInt(1,sectionID);

                List<Section> resultSections = new ArrayList<>();

                sectResultSet = getSectStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

                while(sectResultSet.next()){
                    found = true;

                    Section section = new Section();
                    loadSection(section, sectResultSet, 1);

                    resultSections.add(section);
                }

                if(!found){
                    System.out.println("No Account was found that matched that username");
                }

                return resultSections;
            }
            finally{
                DBUtil.closeQuietly(getSectStmt);
                DBUtil.closeQuietly(sectResultSet);
            }
        });
    }

    @Override
    public List<Section> findAllSections() {
        return executeTransaction(conn -> {
            PreparedStatement getSectStmt = null;
            ResultSet sectResultSet = null;

            try{
                getSectStmt = conn.prepareStatement(
                        "select sections.* from sections"
                );

                List<Section> resultSections = new ArrayList<>();

                sectResultSet = getSectStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

                while(sectResultSet.next()){
                    found = true;

                    Section section = new Section();
                    loadSection(section, sectResultSet, 1);

                    resultSections.add(section);
                }

                if(!found){
                    System.out.println("No sections were found at all (uh-oh)");
                }

                return resultSections;
            }
            finally{
                DBUtil.closeQuietly(getSectStmt);
                DBUtil.closeQuietly(sectResultSet);
            }
        });
    }

    @Override
    public List<Section> findSectionsByCompositionId(Integer compositionId) {
        return executeTransaction(conn -> {
            PreparedStatement getSectStmt = null;
            ResultSet sectResultSet = null;

            try{
                getSectStmt = conn.prepareStatement(
                        "select sections.* from sections where composition_id = ?"
                );
                getSectStmt.setInt(1, compositionId);

                List<Section> resultSections = new ArrayList<>();

                sectResultSet = getSectStmt.executeQuery();

                boolean found = false;

                while(sectResultSet.next()){
                    found = true;

                    Section section = new Section();
                    loadSection(section, sectResultSet, 1);
                    resultSections.add(section);
                }

                if(!found){
                    System.out.println("No sections exist with that composition ID");
                }

                return resultSections;
            }
            finally{
                DBUtil.closeQuietly(getSectStmt);
                DBUtil.closeQuietly(sectResultSet);
            }
        });
    }

    @Override
    public List<Measure> findMeasuresBySectionId(Integer sectionId) {
        return executeTransaction(conn -> {
            PreparedStatement getMeasStmt = null;
            ResultSet measResultSet = null;

            try{
                getMeasStmt = conn.prepareStatement(
                        "Select measures.* from measures "+
                                "where section_id = ?"
                );
                getMeasStmt.setInt(1, sectionId);

                List<Measure> resultMeasures = new ArrayList<>();

                measResultSet = getMeasStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

                while(measResultSet.next()){
                    found = true;

                    Integer measureID = measResultSet.getInt(1);
                    Integer sectionID = measResultSet.getInt(2);

                    Measure measure = new Measure(measureID, sectionID);

                    resultMeasures.add(measure);
                }

                if(!found){
                    System.out.println("No measure(s) was found for that section ID");
                }

                return resultMeasures;
            }
            finally{
                DBUtil.closeQuietly(getMeasStmt);
                DBUtil.closeQuietly(measResultSet);
            }
        });
    }

    /**
     * Finds measures with given measure ID
     *
     * @param measureId unique measure ID
     * @return measures Arraylist of measures
     */
    @Override
    public List<Measure> findMeasuresByMeasureId(Integer measureId) {
        return null;
    }

    @Override
    public List<Measure> findAllMeasures() {
        return executeTransaction(conn -> {
            PreparedStatement getMeasStmt = null;
            ResultSet measResultSet = null;

            try{
                getMeasStmt = conn.prepareStatement(
                        "Select measures.* from measures"
                );

                List<Measure> resultMeasures = new ArrayList<Measure>();

                measResultSet = getMeasStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

                while(measResultSet.next()){
                    found = true;

                    Integer measureID = measResultSet.getInt(1);
                    Integer sectionID = measResultSet.getInt(2);

                    Measure measure = new Measure(measureID, sectionID);

                    resultMeasures.add(measure);
                }

                if(!found){
                    System.out.println("No measures found in databse, no bueno");
                }

                return resultMeasures;
            }
            finally{
                DBUtil.closeQuietly(getMeasStmt);
                DBUtil.closeQuietly(measResultSet);
            }
        });
    }

    @Override
    public Measure insertMeasure(Integer sectionId) {
        return executeTransaction((Connection conn) -> {
            PreparedStatement instMeasStmt = null;
            PreparedStatement getMeasIDStmt = null;
            ResultSet measResultSet = null;

            try{
                instMeasStmt = conn.prepareStatement(
                        "insert into measures (section_id) " +
                                "values(?)"
                );
                instMeasStmt.setInt(1,sectionId);

                instMeasStmt.executeUpdate();

                getMeasIDStmt = conn.prepareStatement(
                        "select measures.* from measures "+
                                "where section_id = ?"
                );
                getMeasIDStmt.setInt(1,sectionId);

                List<Measure> resultMeasures = new ArrayList<>();

                measResultSet = getMeasIDStmt.executeQuery();

                //for testing that result was returned i.e. accounts exist
                Boolean found = false;

//                Integer sectID = -1;

                while(measResultSet.next()){
                    found = true;

                    Integer measureID = measResultSet.getInt(1);
                    Integer sectionID = measResultSet.getInt(2);

                    Measure measure = new Measure(measureID, sectionID);

                    resultMeasures.add(measure);
                }

                if(!found){
                    System.out.println("measure was not added successfully");
                }

                return resultMeasures.get(0);
            }
            finally{
                DBUtil.closeQuietly(instMeasStmt);
                DBUtil.closeQuietly(getMeasIDStmt);
                DBUtil.closeQuietly(measResultSet);
            }
        });
    }


        private void loadAccount(Account account, ResultSet resultSet, int index) throws SQLException {
        account.setAccountID(resultSet.getInt(index++));
        account.setUsername(resultSet.getString(index++));
        account.setPassword(resultSet.getString(index++));
    }

    private void loadComposition(Composition composition, ResultSet resultSet, int index) throws SQLException{
        composition.setCompositionID(resultSet.getInt(index++));
        composition.setTitle(resultSet.getString(index++));
        composition.setYear(resultSet.getInt(index++));
        composition.setDesc(resultSet.getString(index++));
        composition.setAccountId(resultSet.getInt(index++));
        composition.setIsViewablePublicly(resultSet.getInt(index++));
    }

    private void loadSection(Section section, ResultSet resultSet, int index) throws SQLException{
        section.setSectionID(resultSet.getInt(index++));
        section.setKey(Defs.Key.valueOf(resultSet.getString(index++)));
        section.setTimeSig(Defs.TimeSignature.valueOf(resultSet.getString(index++)));
        section.setClef(Defs.Clef.valueOf(resultSet.getString(index++)));
        section.setTempo(resultSet.getInt(index++));
        section.setCompID(resultSet.getInt(index++));
    }

}
