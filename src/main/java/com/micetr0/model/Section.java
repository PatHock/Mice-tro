/*
 *     Server-Side Section model class
 *     Section.java
 *     Created Mar 06, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;

import com.micetr0.definitions.Defs;

public class Section {
    private Integer compID = null;
    private Integer sectionID = null;
    private Integer tempo = null;
    private Defs.Clef clef = null;
    private Defs.Key key = null;
    private Defs.TimeSignature timeSig = null;

    public String getNumTimeSig(){
        return timeSig.getSig();
    }

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
    public Integer getCompID(){return compID;}
    public void setCompID(Integer owningComp) {this.compID = owningComp;}
    public Integer getSectionID(){return sectionID;}
    public void setSectionID(Integer ID){this.sectionID = ID;}
    public void setTempo(Integer tempo)
    {
        this.tempo = tempo;
    }
    public Integer getTempo(){
        return tempo;
    }
}
