/*
 *     Server-Side Note model class
 *     Note.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */

package com.micetr0.model;

public class Note {

    private Type type;
    private int pitch;

    /**
     * Note Constructor
     */
    public Note() {
        this.type = Type.NULL;
    }

    /**
     *
     * @param type The type of the note (SIXTEENTH, EIGHTH etc)
     */
    public void setType(Type type) {
        this.type = type;
    }

    /**
     *
     * @return The type of the note (SIXTEENTH etc) as an object
     */
    public Type getType() {
        return this.type;
    }



    public enum Type {
        SIXTEENTH, EIGHTH, QUARTER, HALF, WHOLE, REST, NULL
    }


}
