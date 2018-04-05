package com.micetr0.mock_DB;

import com.micetr0.model.Account;
import com.micetr0.model.Composition;
import com.micetr0.model.Note;
import java.util.List;

public interface IDatabase {

void insertNote(Note note);

void deleteNote(String noteId);

    /**
     * Multiple notes can exist in the same index in a measure (for a chord), so noteId is the only way to properly
     * distinguish notes
     * @param measureId
     * @param measureIndex
     * @return
     */
    List<Note> findNotesByMeasureIdAndMeasureIndex(Integer measureId, Integer measureIndex);

    List<Composition> findCompositionsIdsByAccountId(Integer accountId);

    List<Note> findNotesByMeasureId(Integer measureId);

    List<Account> findAllAccounts();
}
