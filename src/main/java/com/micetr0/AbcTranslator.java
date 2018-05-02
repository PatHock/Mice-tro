package com.micetr0;

import com.micetr0.model.Composition;
import com.micetr0.model.Note;
import com.micetr0.model.Section;

public class AbcTranslator {

    public AbcTranslator(){
        //blank constructor
    }

    public String getCompTitle(Composition comp){
        return comp.getTitle();
    }

    public String getTimeSig(Section section){
        return section.getTimeSig().getTimeSig();
    }

    public String getNote(Note note){
        if(note.getPitch().toString().endsWith("FLAT")){
            return note.getPitch().toString().substring(0,1);
        }
        if(note.getPitch().toString().endsWith("SHARP")){
            return "^" + note.getPitch().toString().substring(0,1);
        }
        else {
            return note.getPitch().toString().substring(0, 1);
        }
    }

    public String getSomething(){
        return null;
    }





}
