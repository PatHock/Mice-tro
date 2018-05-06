package com.micetr0;

import com.micetr0.definitions.Defs;
import com.micetr0.model.Composition;
import com.micetr0.model.Note;
import com.micetr0.model.Section;
import javafx.util.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbcTranslator {

    public AbcTranslator(){
        //blank constructor
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

    public String abcBuilder(Composition comp, Section sec, List<Note> notes){
        String noties = "";
        Integer prev = 0;
        for (Note note: notes) {
            if(note.getMeasureId().equals(prev))
            {
                String temp = getNote(note);
                noties = noties + " " + temp;
                prev = note.getMeasureId();
            }
            else{
                String temp = getNote(note);
                noties = noties + "|" + temp;
            }
        }
        noties = noties + "|";
        String out = "X: 1\n"
                + "T: " + getCompTitle(comp) + "\n"
                + "M: " + getTimeSig(sec) + "\n"
                + "L: 1/8 \n"
                + "R: reel \n"
                + "K: " + getKey(sec) + "\n"
                + " |"
                + noties;
        return out;
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
    public List<String> extractNotes(List<String> noteMeasures){
        List<String> allNotes = new ArrayList<>();
        for (String noteMeas: noteMeasures) {
            String temp = noteMeas.replaceAll("\\s+","");
            allNotes.addAll(Arrays.asList(temp.split("(?<= |A|B|C|D|E|F|G)")));
        }
        return allNotes;
    }
}
