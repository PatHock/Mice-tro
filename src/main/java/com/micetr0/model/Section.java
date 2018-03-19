/*
 *     Server-Side Section model class
 *     Section.java
 *     Created Mar 06, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;

import com.micetr0.definitions.Defs;

public class Section {
    private String owningComp = null;
    private String sectionID = null;
    private Integer tempo = null;
    private Defs.Clef clef = null;
    private Defs.Key key = null;
    private Defs.TimeSignature timeSig = null;

    public Defs.TimeSignature getTimeSig() {
        return timeSig;
    }
    public void setTimeSig(Defs.TimeSignature timeSig) {
        this.timeSig = timeSig;
    }

    public Defs.Key getKey() {
        return key;
    }
    public void setKey(Defs.Key key) {
        this.key = key;
    }
    public Defs.Clef getClef() {
        return clef;
    }
    public void setClef(Defs.Clef clef) {
        this.clef = clef;
    }
    public String getOwningComp(){return owningComp;}
    public void setOwningComp(String owningComp) {this.owningComp = owningComp;}
    public String getsectionID(){return sectionID;}
    public void setSectionID(String ID){this.sectionID = ID;}
    public void setTempo(Integer tempo)
    {
        this.tempo = tempo;
    }
    public Integer getTempo(){
        return tempo;
    }
}
