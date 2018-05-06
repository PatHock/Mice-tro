package com.micetr0.definitions;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DefsTest {

    @BeforeEach
    void setUp(){

    }

    @Test
    void KeyTest() {
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
    void NoteTypeTest() {
        assertTrue(Defs.NoteType.WHOLE.getSize().equals(2 * Defs.NoteType.HALF.getSize()));
        assertFalse(Defs.NoteType.EIGHTH.getSize().equals(Defs.NoteType.QUARTER.getSize()));

    }

    @Test
    void PitchTest() {
        // TODO: Implement more rigorous testing
        assertTrue(Defs.Pitch.A4.getFrequency() == (2 * Defs.Pitch.A3.getFrequency()));

    }

    @AfterEach
    void tearDown(){

    }
}