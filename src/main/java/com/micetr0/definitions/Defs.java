package com.micetr0.definitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Defs {

    public enum NoteType {
        SIXTEENTH(0.0625),
        EIGHTH(0.125),
        QUARTER(0.25),
        HALF(0.5),
        WHOLE(1.0);

        private final Double size;  // fraction of a whole note

        NoteType(Double size) {
            this.size = size;
        }

        public Double getSize() {
            return this.size;
        }

        private static final Map<Double, NoteType> map;

        static {
            map = new HashMap<Double, NoteType>();
            for (NoteType v : NoteType.values()) {
                map.put(v.size, v);
            }
        }

        public static NoteType findByKey(Double size) {
            return map.get(size);
        }
    }

    public enum Pitch {
        // Source for frequencies: https://pages.mtu.edu/~suits/notefreqs.html
        // Based off of Oracle documentation https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
        C0(16.35),
        C0_SHARP(17.32),
        D0_FLAT(17.32),
        D0(18.35),
        D0_SHARP(19.45),
        E0_FLAT(19.45),
        E0(20.60),
        F0(21.83),
        F0_SHARP(23.12),
        G0_FLAT(23.12),
        G0(24.50),
        G0_SHARP(25.96),
        A0_FLAT(25.96),
        A0(27.50),
        A0_SHARP(29.14),
        B0_FLAT(29.14),
        B0(30.87),

        C1(32.70),
        C1_SHARP(32.70),
        D1_FLAT(34.65),
        D1(36.71),
        D1_SHARP(38.89),
        E1_FLAT(38.89),
        E1(41.20),
        F1(43.65),
        F1_SHARP(46.25),
        G1_FLAT(46.25),
        G1(49.00),
        G1_SHARP(51.91),
        A1_FLAT(51.91),
        A1(55.00),
        A1_SHARP(58.27),
        B1_FLAT(58.27),
        B1(61.74),

        C2(65.41),
        C2_SHARP(69.30),
        D2_FLAT(69.30),
        D2(73.42),
        D2_SHARP(77.78),
        E2_FLAT(77.78),
        E2(82.41),
        F2(87.31),
        F2_SHARP(92.50),
        G2_FLAT(92.50),
        G2(98.00),
        G2_SHARP(103.83),
        A2_FLAT(103.83),
        A2(110.00),
        A2_SHARP(116.54),
        B2_FLAT(116.54),
        B2(123.47),

        C3(130.81),
        C3_SHARP(138.59),
        D3_FLAT(138.59),
        D3(146.83),
        D3_SHARP(155.56),
        E3_FLAT(155.56),
        E3(164.81),
        F3(174.61),
        F3_SHARP(185.00),
        G3_FLAT(185.00),
        G3(196.00),
        G3_SHARP(207.65),
        A3_FLAT(207.65),
        A3(220.00),
        A3_SHARP(233.08),
        B3_FLAT(233.08),
        B3(246.94),

        C4(261.63),
        C4_SHARP(277.18),
        D4_FLAT(277.18),
        D4(293.66),
        D4_SHARP(311.13),
        E4_FLAT(311.13),
        E4(329.63),
        F4(349.23),
        F4_SHARP(369.99),
        G4_FLAT(369.99),
        G4(392.00),
        G4_SHARP(415.30),
        A4_FLAT(415.30),
        A4(440.00),
        A4_SHARP(466.16),
        B4_FLAT(466.16),
        B4(493.88),

        C5(523.25),
        C5_SHARP(554.37),
        D5_FLAT(554.37),
        D5(587.33),
        D5_SHARP(622.25),
        E5_FLAT(622.25),
        E5(659.25),
        F5(698.46),
        F5_SHARP(739.99),
        G5_FLAT(739.99),
        G5(783.99),
        G5_SHARP(830.61),
        A5_FLAT(830.61),
        A5(880.00),
        A5_SHARP(932.33),
        B5_FLAT(932.33),
        B5(987.77),

        C6(1046.50),
        C6_SHARP(1108.73),
        D6_FLAT(1108.73),
        D6(1174.66),
        D6_SHARP(1244.51),
        E6_FLAT(1244.51),
        E6(1318.51),
        F6(1396.91),
        F6_SHARP(1479.98),
        G6_FLAT(1479.98),
        G6(1567.98),
        G6_SHARP(1661.22),
        A6_FLAT(1661.22),
        A6(1864.66),
        A6_SHARP(1864.66),
        B6_FLAT(1864.66),
        B6(1975.53),

        C7(2093.00),
        C7_SHARP(2217.46),
        D7_FLAT(2217.46),
        D7(2349.32),
        D7_SHARP(2489.02),
        E7_FLAT(2489.02),
        E7(2637.02),
        F7(2793.83),
        F7_SHARP(2959.96),
        G7_FLAT(2959.96),
        G7(3135.96),
        G7_SHARP(3322.44),
        A7_FLAT(3322.44),
        A7(3520.00),
        A7_SHARP(3729.31),
        B7_FLAT(3729.31),
        B7(3951.07),

        C8(4186.01),  // G_Major
        C8_SHARP(4434.92),  //
        D8_FLAT(4434.92),  //
        D8(4698.63),  // G_MAJOR
        D8_SHARP(4978.03),  //
        E8_FLAT(4978.03),  //
        E8(5274.04),  // G_MAJOR
        F8(5587.65),  //
        F8_SHARP(5919.91),  // G_MAJOR
        G8_FLAT(5919.91),  //
        G8(6271.93),  // G_MAJOR
        G8_SHARP(6644.88),  //
        A8_FLAT(6644.88),  //
        A8(7040.00),  // G_Major
        A8_SHARP(7458.62),  //
        B8_FLAT(7458.62),  //
        B8(7902.13),  // G_Major

        REST(0.0);

        private final Double frequency; // in Hertz

        Pitch(Double frequency) {
            this.frequency = frequency;
        }

        public Double getFrequency() {
            return this.frequency;
        }

    }

    public enum Key {
        // Uses 7 notes per octave scales
        // https://insights.spotify.com/us/2015/05/06/most-popular-keys-on-spotify/
        // TODO: Add More Keys

        G_MAJOR(new ArrayList<>(Arrays.asList(
                Pitch.A0, Pitch.A1, Pitch.A2, Pitch.A3, Pitch.A4, Pitch.A5, Pitch.A6, Pitch.A7, Pitch.A8,
                Pitch.B0, Pitch.B1, Pitch.B2, Pitch.B3, Pitch.B4, Pitch.B5, Pitch.B6, Pitch.B7, Pitch.B8,
                Pitch.C0, Pitch.C1, Pitch.C2, Pitch.C3, Pitch.C4, Pitch.C5, Pitch.C6, Pitch.C7, Pitch.C8,
                Pitch.D0, Pitch.D1, Pitch.D2, Pitch.D3, Pitch.D4, Pitch.D5, Pitch.D6, Pitch.D7, Pitch.D8,
                Pitch.E0, Pitch.E1, Pitch.E2, Pitch.E3, Pitch.E4, Pitch.E5, Pitch.E6, Pitch.E7, Pitch.E8,
                Pitch.F0_SHARP, Pitch.F1_SHARP, Pitch.F2_SHARP, Pitch.F3_SHARP, Pitch.F4_SHARP, Pitch.F5_SHARP, Pitch.F6_SHARP, Pitch.F7_SHARP, Pitch.F8_SHARP,
                Pitch.G0, Pitch.G1, Pitch.G2, Pitch.G3, Pitch.G4, Pitch.G5, Pitch.G6, Pitch.G7, Pitch.G8
        ))),

        C_MAJOR(new ArrayList<>(Arrays.asList(
                Pitch.A0, Pitch.A1, Pitch.A2, Pitch.A3, Pitch.A4, Pitch.A5, Pitch.A6, Pitch.A7, Pitch.A8,
                Pitch.B0, Pitch.B1, Pitch.B2, Pitch.B3, Pitch.B4, Pitch.B5, Pitch.B6, Pitch.B7, Pitch.B8,
                Pitch.C0, Pitch.C1, Pitch.C2, Pitch.C3, Pitch.C4, Pitch.C5, Pitch.C6, Pitch.C7, Pitch.C8,
                Pitch.D0, Pitch.D1, Pitch.D2, Pitch.D3, Pitch.D4, Pitch.D5, Pitch.D6, Pitch.D7, Pitch.D8,
                Pitch.E0, Pitch.E1, Pitch.E2, Pitch.E3, Pitch.E4, Pitch.E5, Pitch.E6, Pitch.E7, Pitch.E8,
                Pitch.F0, Pitch.F1, Pitch.F2, Pitch.F3, Pitch.F4, Pitch.F5, Pitch.F6, Pitch.F7, Pitch.F8,
                Pitch.G0, Pitch.G1, Pitch.G2, Pitch.G3, Pitch.G4, Pitch.G5, Pitch.G6, Pitch.G7, Pitch.G8
        ))),

        D_MAJOR(new ArrayList<>(Arrays.asList(
                Pitch.A0, Pitch.A1, Pitch.A2, Pitch.A3, Pitch.A4, Pitch.A5, Pitch.A6, Pitch.A7, Pitch.A8,
                Pitch.B0, Pitch.B1, Pitch.B2, Pitch.B3, Pitch.B4, Pitch.B5, Pitch.B6, Pitch.B7, Pitch.B8,
                Pitch.C0_SHARP, Pitch.C1_SHARP, Pitch.C2_SHARP, Pitch.C3_SHARP, Pitch.C4_SHARP, Pitch.C5_SHARP, Pitch.C6_SHARP, Pitch.C7_SHARP, Pitch.C8_SHARP,
                Pitch.D0, Pitch.D1, Pitch.D2, Pitch.D3, Pitch.D4, Pitch.D5, Pitch.D6, Pitch.D7, Pitch.D8,
                Pitch.E0, Pitch.E1, Pitch.E2, Pitch.E3, Pitch.E4, Pitch.E5, Pitch.E6, Pitch.E7, Pitch.E8,
                Pitch.F0_SHARP, Pitch.F1_SHARP, Pitch.F2_SHARP, Pitch.F3_SHARP, Pitch.F4_SHARP, Pitch.F5_SHARP, Pitch.F6_SHARP, Pitch.F7_SHARP, Pitch.F8_SHARP,
                Pitch.G0, Pitch.G1, Pitch.G2, Pitch.G3, Pitch.G4, Pitch.G5, Pitch.G6, Pitch.G7, Pitch.G8
        )));


        private final ArrayList<Pitch> pitches;

        /**
         * Key Constructor
         *
         * @param pitches An ArrayList of the pitches contained within a key
         */
        Key(ArrayList<Pitch> pitches) {
            this.pitches = pitches;
        }

        /**
         * @return An ArrayList of pitch objects within a key
         */
        public ArrayList<Pitch> getPitches() {
            return pitches;
        }

        /**
         * @param pitch A pitch object
         * @return Boolean, representing whether or not the pitch is contained in this key. Used for verification by Note Controller
         */
        public Boolean isValidPitch(Pitch pitch) {
            return getPitches().contains(pitch);
        }

    }

    public enum Clef {
        BASS,
        TREBLE,

    }

    public enum TimeSignature {
        TWO_FOUR("2/4"),
        THREE_FOUR("3/4"),
        FOUR_FOUR("4/4"),
        THREE_EIGHT("3/8"),
        FOUR_EIGHT("4/8"),
        SIX_EIGHT("6/8"),
        SEVEN_EIGHT("7/8"),
        EIGHT_EIGHT("8/8"),
        SEVEN_SIXTEEN("7/16"),
        EIGHT_SIXTEEN("8/16"),
        NINE_SIXTEEN("9/16"),
        TEN_SIXTEEN("10/16"),
        ELEVEN_SIXTEEN("11/16"),
        TWELVE_SIXTEEN("12/16"),
        THIRTEEN_SIXTEEN("13/16"),
        FOURTEEN_SIXTEEN("14/16"),
        FIFTEEN_SIXTEEN("15/16"),
        SIXTEEN_SIXTEEN("16/16");

        private final String sig; // in its components

        TimeSignature(String sig) {
            this.sig = sig;
        }

        public String getSig() {
            return this.sig;
        }

        private static final Map<String, TimeSignature> map;

        static {
            map = new HashMap<String, TimeSignature>();
            for (TimeSignature v : TimeSignature.values()) {
                map.put(v.sig, v);
            }
        }

        public static TimeSignature findByKey(String sig) {
            return map.get(sig);
        }
    }
}