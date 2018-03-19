package com.micetr0.mock_DB;

import com.micetr0.definitions.Defs;
import com.micetr0.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.micetr0.definitions.*;

public class InitialData {

    /**
     * @return List<Account></>
     * @throws IOException We're Dealing with CSVs here
     */

    public static List<Account> getAccounts() throws IOException{
        List<Account> accounts = new ArrayList<>();
        try (CSVParse parseAccounts = new CSVParse("accounts.csv")) {
            Integer accountID = 1;
            while (true) {
                List<String> tuple = parseAccounts.next();
                if (tuple == null) {
                    break;
                }
                Iterator<String> i = tuple.iterator();
                Account account = new Account();
                //set fields
                accounts.add(account);
            }
            return accounts;
        }
    }


    public static List<Composition> getCompositions() throws IOException{
        List<Composition> compositions = new ArrayList<>();
        try (CSVParse parseCompositions = new CSVParse("compositions.csv")) {
            Integer compositionID = 1;
            while (true) {
                List<String> tuple = parseCompositions.next();
                if (tuple == null) {
                    break;
                }
                Iterator<String> i = tuple.iterator();
                Composition composition = new Composition();
                //setfields
                compositions.add(composition);
            }
            return compositions;
        }
    }

    public static List<Section> getSections() throws IOException{
        List<Section> sections = new ArrayList<>();
        try (CSVParse parseSections = new CSVParse("sections.csv")) {
            Integer sectionID = 1;
            while (true) {
                List<String> tuple = parseSections.next();
                if (tuple == null) {
                    break;
                }
                Iterator<String> i = tuple.iterator();
                Section section = new Section();
                //set fields
                sections.add(section);
            }
            return sections;
        }
    }

    public static List<Note> getNotes() throws IOException{
        List<Note> notes = new ArrayList<>();
        try (CSVParse parseNotes = new CSVParse("notes.csv")) {
            Integer NoteID = 1;
            while (true) {
                List<String> tuple = parseNotes.next();
                if (tuple == null) {
                    break;
                }
                Iterator<String> i = tuple.iterator();
                Note note = new Note(Integer.parseInt(i.next()), setNoteType(i.next()), setPitch(i.next()), Integer.parseInt(i.next()), Integer.parseInt(i.next()));
                notes.add(note);
            }
            return notes;
        }
    }

    public static Defs.NoteType setNoteType(String stringNote)
    {
        Defs.NoteType[] noteTypes = Defs.NoteType.class.getEnumConstants();
        for (Defs.NoteType type : noteTypes)
        {
            if(type.name().equals(stringNote))
            {
                return type;
            }
        }
        return null;
    }

    public static Defs.Pitch setPitch(String stringPitch)
    {
        Defs.Pitch[] notePitch = Defs.Pitch.class.getEnumConstants();
        for (Defs.Pitch pitch : notePitch)
        {
            if(pitch.name().equals(stringPitch))
            {
                return pitch;
            }
        }
        return null;
    }
}