package com.micetr0;

import com.micetr0.controller.CompositionController;
import com.micetr0.controller.MeasureController;
import com.micetr0.controller.NoteController;
import com.micetr0.controller.SectionController;
import com.micetr0.definitions.Defs;
import com.micetr0.mock_DB.DatabaseProvider;
import com.micetr0.mock_DB.IDatabase;
import com.micetr0.model.Composition;
import com.micetr0.model.Measure;
import com.micetr0.model.Note;
import com.micetr0.model.Section;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbcTranslator {

    private IDatabase db;

    public AbcTranslator(){
        db = DatabaseProvider.getInstance();
    }

    public String getCompTitle(Composition comp){
        return comp.getTitle();
    }

    public String getTimeSig(Section section){
        return section.getNumTimeSig();
    }

    public String getNote(Note note){
        if(note.getPitch().toString().endsWith("FLAT")){
            return "_" + note.getPitch().toString().substring(0,2);
        }
        if(note.getPitch().toString().endsWith("SHARP")){
            return "^" + note.getPitch().toString().substring(0,2);
        }
        else {
            return note.getPitch().toString().substring(0,2);
        }
    }


    public String getKey(Section sec){
        String pre = sec.getKey().toString();
        String post;
        if(pre.equals("G_MAJOR")){
            post = "G";
        }
        else if(pre.equals("C_MAJOR")){
            post = "C";
        }
        else{
            post = "D";
        }
        return post;
    }

    public String abcBuilder(Composition comp){
        String noties = "";
        Integer prev = 0;
        int index = 0;
        List<Note> noteList = new ArrayList<>();
        List<Section> sectionList = db.findSectionsByCompositionId(comp.getCompositionID());
        List<Measure> measureList = new ArrayList<>();
        for(Section section : sectionList){
            measureList.addAll(db.findMeasuresBySectionId(section.getSectionID()));
        }
        for(Measure measure : measureList){
            noteList.addAll(db.findNotesByMeasureId(measure.getMeasureID()));
        }

        for (Note note: noteList) {
            System.out.println("Found a note in this composition!");
            if(index == 0){
                String temp = getNote(note);
                noties = noties + temp;
                prev = note.getMeasureId();
                index ++;
            }
            else {
                if (note.getMeasureId().equals(prev)) {
                    String temp = getNote(note);
                    noties = noties + " " + temp;
                    prev = note.getMeasureId();
                    index ++;
                } else {
                    String temp = getNote(note);
                    noties = noties + "|" + temp;
                    prev = note.getMeasureId();
                    index = 1;
                }
            }
        }

        noties = noties + "|";
        System.out.println(noties);
        String out = "X: 1\n"
                + "T: " + getCompTitle(comp) + "\n"
                + "M: " + getTimeSig(sectionList.get(0)) + "\n"
                + "L: 1/8 \n"
                + "R: reel \n"
                + "K: " + getKey(sectionList.get(0)) + "\n"
                + " |"
                + noties;
        return out;
    }

    public Defs.NoteType createNoteType(String note){
        Double defaultLength = .125;
        Integer end = Integer.parseInt(note.substring(note.length() - 1));

        Double size = defaultLength * end;

        return Defs.NoteType.findByKey(size);
    }

    public Defs.Pitch createNotePitch(String notePitch){
        String post;
        if(notePitch.startsWith("_")){
            post = notePitch.substring(1,3)+"_FLAT";
        }
        else if(notePitch.startsWith("*")){
            post = notePitch.substring(1,3)+"_SHARP";
        }
        else{
            post = notePitch;
        }
        return Defs.Pitch.valueOf(post);
    }
    public Defs.TimeSignature createTimeSignature(String timeSignature){
        Defs.TimeSignature timeSig = Defs.TimeSignature.findByKey(timeSignature);
        return timeSig;
    }
    public Defs.Key createKey(String key){
        String post;
        if(key.equals("G")){
            post = "G_MAJOR";
        }
        else if(key.equals("C")){
            post = "C_MAJOR";
        }
        else{
            post = "D_MAJOR";
        }
        return Defs.Key.valueOf(post);
    }
    public Defs.Clef createClef(String clef){
        return Defs.Clef.TREBLE;
    }

    /**
     * Create a List of Strings that represent the composition
     * @param abc   String representation of composition information
     * @return      List of composition pieces
     */

    public List<String> parseABC(String abc){
        List<String> abcComponents = Arrays.asList(abc.split("\\r?\\n"));
        return abcComponents;
    }

    public List<String> extractNoteMeasures(String abc) {
        String allNotes = parseABC(abc).get(6);
        List<String> measures = Arrays.asList(allNotes.split("\\|"));
        return measures;
    }

    /**
     * Separate Individual notes and prepare to create Note objects
     * @param noteMeasures
     * @return
     */
    public List<String> extractNoteStrings(List<String> noteMeasures){
        List<String> allNotes = new ArrayList<>();
        int measureId = 0;
        for (String noteMeas: noteMeasures) {
            String temp = noteMeas.replaceAll("\\s+","");
            allNotes.addAll(Arrays.asList(temp.split("(?<= |0|1|2|3|4|5|6)")));
        }
        return allNotes;
    }

    public List<Note> extractNotes(List<String> noteMeasures){
        List<Note> allNotes = new ArrayList<>();
        int measureId = 0;
        for(String noteMeas: noteMeasures){
            String temp = noteMeas.replaceAll("\\s+", "");
            List<String> preNote = Arrays.asList(temp.split("(?<= |0|1|2|3|4|5|6)"));
            for (String note: preNote) {
                int index = 0;
                Note newNote = new Note(0,createNoteType(note),createNotePitch(note),index,measureId);
                index++;
                allNotes.add(newNote);
            }
            measureId++;
        }

        return allNotes;
    }
}
