/*
 *     Server-Side Note model class
 *     Note.java
 *     Created Mar 08, 2018 by Patrick Hock
 *     Insert Description Here
 */
package com.micetr0.model;

public class Note {

    private Type type;
    private Pitch pitch;
    private Integer measureIndex;
    private Integer measureId;
    private Integer sectionId;
    private Integer compositionId;

    public enum Type {
        SIXTEENTH (0.0625),
        EIGHTH (0.125),
        QUARTER (0.25),
        HALF (0.5),
        WHOLE (1.0),
        REST_SIXTEENTH (0.0625),
        REST_EIGHTH (0.125),
        REST_QUARTER (0.25),
        REST_HALF (0.5),
        REST_WHOLE (1.0);

        private final Double size;  // fraction of a whole note

        Type(Double size) {
            this.size = size;
        }

        public Double getSize() {
            return this.size;
        }
    }

    //TODO: Add more notes
    public enum Pitch {
        // Source for frequencies: https://pages.mtu.edu/~suits/notefreqs.html
        // Based off of Oracle documentation https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
        C0 (16.35),
        D0 (18.35),
        E0 (20.60),
        F0 (21.83),
        G0 (24.50),
        A0 (27.50),
        B0 (30.87),
        C1 (32.70),
        D1 (36.71),
        E1 (41.20),
        F1 (43.65),
        G1 (49.00),
        A1 (55.00),
        REST (0.0);
        private final Double frequency; // in Hertz

        Pitch(Double frequency){
            this.frequency = frequency;
        }

        public Double getFrequency() {
            return this.frequency;
        }

    }

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
    public Note(Type type, Pitch pitch, Integer measureIndex, Integer measureId, Integer sectionId, Integer compositionId) {
    //empty constructor
        setType(type);
        setPitch(pitch);
        setMeasureIndex(measureIndex);
        setMeasureId(measureId);
        setSectionId(sectionId);
        setCompositionId(compositionId);
    }


    /**
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

    /**
     * @param pitch The frequency of the note in Hertz
     */
    public void setPitch(Pitch pitch) {
        this.pitch = pitch;
    }

    /**
     *
     * @return Pitch object
     */
    public Pitch getPitch() {
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
