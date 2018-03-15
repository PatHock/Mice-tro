/*
 *     Server-Side Note model class
 *     Note.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;


public class Note {

    private Type type;
    private Double pitch;
    private Boolean isSetType = false;

    public enum Type {
        SIXTEENTH, EIGHTH, QUARTER, HALF, WHOLE, REST
    }

    /*
     * Note Constructor
     */
    public Note() {
        this.type = Type.REST;
        this.isSetType = false;
    }

    /**
     * @param type The type of the note (SIXTEENTH, EIGHTH etc)
     */
    public void setType(Type type) {
        this.type = type;
        this.isSetType = true;
    }

    /**
     *
     * @return The type of the note (SIXTEENTH etc) as an object
     */
    public Type getType() {
        return this.type;
    }

    /**
     * @param pitch The frequency of the note in Hertz
     */
    public void setPitch(Double pitch) {
        this.pitch = pitch;
    }

    /**
     * @return  The frequency of the note in Hertz
     */
    public Double getPitch() {
        return this.pitch;
    }

    /**
     *
     * @return Boolean Indicates whether or not the note type has been set externally
     */
    public Boolean isSetType() {
        return isSetType;
    }


}
