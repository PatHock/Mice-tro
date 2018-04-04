package com.micetr0.mock_DB;

import com.micetr0.model.Account;
import com.micetr0.model.Composition;
import com.micetr0.model.Note;
import java.util.List;

public interface IDatabase {

    List<Note> findNotesByMeasureIdAndMeasureIndex(Integer measureId, Integer measureIndex);

    List<Composition> findCompositionsIdsByAccountId(Integer accountId);


}
