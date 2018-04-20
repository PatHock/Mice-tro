package com.micetr0.mock_DB;

import com.micetr0.definitions.Defs;
import com.micetr0.model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
                account.setUsername(i.next());
                account.setPassword(i.next());
                account.setAccountID(accountID);
                String editableComps[] = i.next().split(" ");
                List<String> editable = Arrays.asList(editableComps);
                String viewableComps[] = i.next().split(" ");
                List<String> viewable = Arrays.asList(viewableComps);
                account.setEditableComps(editable);
                account.setViewableComps(viewable);
                accounts.add(account);
                accountID++;
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
                composition.setTitle(i.next());
                composition.setYear(Integer.parseInt(i.next()));
                composition.setCompositionID(compositionID);
                compositionID++;
                composition.setDesc(i.next());
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
                section.setSectionID(sectionID);
                sectionID++;
                section.setKey(Defs.Key.valueOf(i.next()));
                section.setTimeSig(Defs.TimeSignature.valueOf(i.next()));
                section.setClef(Defs.Clef.valueOf(i.next()));
                section.setTempo(Integer.parseInt(i.next()));
                section.setCompID(Integer.parseInt(i.next()));
                sections.add(section);
            }
            return sections;
        }
    }

    public static List<Measure> getMeasures() throws IOException{
        List<Measure> measures = new ArrayList<>();
        try (CSVParse parseMeasures = new CSVParse("measures.csv")){
            Integer MeasureID = 1;
            while(true) {
                List<String> tuple = parseMeasures.next();
                if(tuple == null) {
                    break;
                }
                Iterator<String> i = tuple.iterator();
                Measure measure = new Measure(Integer.parseInt(i.next()), Integer.parseInt(i.next()));
            }
        }
        return measures;
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
                //Note note = new Note(Integer.parseInt(i.next()), setNoteType(i.next()), setPitch(i.next()), Integer.parseInt(i.next()), Integer.parseInt(i.next()));
                Note note = new Note(NoteID, setNoteType(i.next()), setPitch(i.next()), Integer.parseInt(i.next()), Integer.parseInt(i.next()));
                NoteID ++;
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