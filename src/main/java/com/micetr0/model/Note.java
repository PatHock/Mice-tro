/*
 *     Server-Side Note model class
 *     Note.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */
package com.micetr0.model;
import com.micetr0.definitions.Defs;

public class Note {

    private Defs.NoteType noteType;
    private Defs.Pitch pitch;
    private Integer measureIndex;
    private Integer measureId;
    private Integer noteID;


    /**
     * Note Constructor
     * Every Note object should have all of these attributes to be stored in the database
     * @param noteID        The index of Note in database
     * @param type          The type of the note (ex: Sixteenth)
     * @param pitch         The specific Note, with reference A0 = 440 Hz
     * @param measureIndex  The position of a note within a measure, 0 being the first note in the measure
     * @param measureId     The unique ID of the measure that contains this note
     */
    public Note(Integer noteID, Defs.NoteType type, Defs.Pitch pitch, Integer measureIndex, Integer measureId) {
        setNoteID(noteID);
        setType(type);
        setPitch(pitch);
        setMeasureIndex(measureIndex);
        setMeasureId(measureId);
    }

    /**
     * Just your standard model set method
     * @param noteID unique ID for note
     */
    public void setNoteID(Integer noteID)
    {
        this.noteID = noteID;
    }

    /**
     *
     * @return unique ID for note
     */
    public Integer getNoteID(){
        return noteID;
    }

    /**
     * @param noteType The type of the note (SIXTEENTH, EIGHTH etc)
     */
    public void setType(Defs.NoteType noteType) {
        this.noteType = noteType;
    }

    /**
     *
     * @return The type of the note (SIXTEENTH etc) as an object
     */
    public Defs.NoteType getType() {
        return this.noteType;
    }

    /**
     * @param pitch The frequency of the note in Hertz
     */
    public void setPitch(Defs.Pitch pitch) {
        this.pitch = pitch;
    }

    /**
     *
     * @return Pitch object
     */
    public Defs.Pitch getPitch() {
        return pitch;
    }

    /**
     * @return  The frequency of the note in Hertz
     */
    public Double getFrequency() {
        return this.pitch.getFrequency();
    }

    /**
     * @return  Index (position) of note in its measure, 0 being the leftmost position
     */
    public Integer getMeasureIndex() {
        return measureIndex;
    }



    /**
     * @return Unique database ID for the measure this note is associated with
     */
    public Integer getMeasureId() {
        return measureId;
    }

    /**
     * @param measureId Unique database ID for the measure this note is associated with
     */
    public void setMeasureId(Integer measureId) {
        this.measureId = measureId;
    }

    /**
     * @param measureIndex Index (position) of note in its measure, 0 being the leftmost position
     */
    public void setMeasureIndex(Integer measureIndex) {
        this.measureIndex = measureIndex;
    }

}
