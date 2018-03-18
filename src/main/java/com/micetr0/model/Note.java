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
    private Integer sectionId;
    private Integer compositionId;


    /**
     * Note Constructor
     * Every Note object should have all of these attributes to be stored in the database
     * @param type          The type of the note (ex: Sixteenth)
     * @param pitch         The specific Note, with reference A0 = 440 Hz
     * @param measureIndex  The position of a note within a measure, 0 being the first note in the measure
     * @param measureId     The unique ID of the measure that contains this note
     * @param sectionId     The unique ID of the section that contains this note
     * @param compositionId The unique ID of the composition that contains this note
     */
    public Note(Defs.NoteType type, Defs.Pitch pitch, Integer measureIndex, Integer measureId, Integer sectionId, Integer compositionId) {
        setType(type);
        setPitch(pitch);
        setMeasureIndex(measureIndex);
        setMeasureId(measureId);
        setSectionId(sectionId);
        setCompositionId(compositionId);
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
     * @return Unique database ID for the composition this note is associated with
     */
    public Integer getCompositionId() {
        return compositionId;
    }

    /**
     * @return Unique database ID for the measure this note is associated with
     */
    public Integer getMeasureId() {
        return measureId;
    }

    /**
     * @return Unique database ID for the section this note is associated with
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * @param compositionId Unique database ID for the composition this note is associated with
     */
    public void setCompositionId(Integer compositionId) {
        this.compositionId = compositionId;
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

    /**
     * @param sectionId Unique database ID for the section this note is associated with
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }
}
