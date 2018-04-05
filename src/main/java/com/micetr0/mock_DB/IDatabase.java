package com.micetr0.mock_DB;

import com.micetr0.model.Note;
import java.util.List;

public interface IDatabase {

    void insertNote(Note note);

    /**
     * Multiple notes can exist in the same index in a measure (for a chord), so noteId is the only way
     * to properly distinguish notes
     * @param noteId Unique database ID for note
     */
    void deleteNote(String noteId);

    List<Note> findNotesByMeasureIdAndMeasureIndex(Integer measureId, Integer measureIndex);
    //List<Note> findNotesByMeasureId(Integer measureId);

}
