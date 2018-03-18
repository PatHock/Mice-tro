package com.micetr0.definitions;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefsTest {

    @Before
    public void setUp(){

    }

    @Test
    public void KeyTest() {
        Defs.Pitch pitch = Defs.Pitch.A4;
        Defs.Pitch anotherPitch = Defs.Pitch.C3;

        Defs.Key key = Defs.Key.C_MAJOR;

        assertTrue(key.isValidPitch(pitch));
        assertTrue(key.isValidPitch(anotherPitch));

        assertFalse(key.isValidPitch(Defs.Pitch.A0_SHARP));
        assertFalse(key.isValidPitch(Defs.Pitch.F8_SHARP));
        assertFalse(key.isValidPitch(Defs.Pitch.A0_FLAT));
        assertFalse(key.isValidPitch(Defs.Pitch.G5_FLAT));

    }

    @Test
    public void NoteTypeTest() {
        assertTrue(Defs.NoteType.REST_WHOLE.getSize().equals(2 * Defs.NoteType.HALF.getSize()));
        assertFalse(Defs.NoteType.REST_EIGHTH.getSize().equals(Defs.NoteType.QUARTER.getSize()));

    }

    @Test
    public void PitchTest() {
        // TODO: Implement more rigorous testing
        assertTrue(Defs.Pitch.A4.getFrequency() == (2 * Defs.Pitch.A3.getFrequency()));

    }

    @After
    public void tearDown(){

    }
}