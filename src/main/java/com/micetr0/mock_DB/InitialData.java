package com.micetr0.mock_DB;

import com.micetr0.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InitialData {

    /**
     * @return List<Account></>
     * @throws IOException
     */
    /*
    public static List<Account> getAccounts() throws IOException{
        List<Account> accounts = new ArrayList<>();
        CSVParse parseAccounts = new CSVParse("accounts.csv");
            try{
            Integer compositionID = 1;
            while (true)
            {
                List<String> tuple = parseAccounts.next();
                if(tuple == null)
                {
                    break;
                }
                Iterator<String> i = tuple.iterator();
                Account account = new Account();
                //set fields
                accounts.add(account);
            }
            return accounts;
        }
            finally {
            parseAccounts.close();
        }
    }
    */

    public static List<Composition> getCompositions() throws IOException{
        List<Composition> compositions = new ArrayList<Composition>();
        CSVParse parseCompositions = new CSVParse("compositions.csv");
        try{
            Integer compositionID = 1;
            while (true)
            {
                List<String> tuple = parseCompositions.next();
                if(tuple == null)
                {
                    break;
                }
                Iterator<String> i = tuple.iterator();
                Composition composition = new Composition();
                //setfields
                compositions.add(composition);
            }
            return compositions;
        }
        finally {
            parseCompositions.close();
        }
    }

    public static List<Section> getSections() throws IOException{
        List<Section> sections = new ArrayList<>();
        CSVParse parseSections = new CSVParse("sections.csv");
        try{
            Integer sectionID = 1;
            while (true)
            {
                List<String> tuple = parseSections.next();
                if(tuple == null)
                {
                    break;
                }
                Iterator<String> i = tuple.iterator();
                Section section = new Section();
                //set fields
                sections.add(section);
            }
            return sections;
        }
        finally {
            parseSections.close();
        }
    }

    public static List<Note> getNotes() throws IOException{
        List<Note> notes = new ArrayList<>();
        CSVParse parseNotes = new CSVParse("notes.csv");
        try{
            Integer NoteID = 1;
            while (true)
            {
                List<String> tuple = parseNotes.next();
                if(tuple == null)
                {
                    break;
                }
                Iterator<String> i = tuple.iterator();
                Note note = new Note();
                //set fields
                notes.add(note);
            }
            return notes;
        }
        finally {
            parseNotes.close();
        }
    }

}