package projectakhir.note.app.core.data.note;

import java.util.List;

public interface NoteDao {

    void insert(String title, String content, String date, String author);
    void delete(String id);
    void update(String id, String title, String content, String date, String author);
    List<NoteEntity> getAllNotes(String author);
    NoteEntity getSelectedNote(String id);
    boolean isIdExist(String id, String author);
}
