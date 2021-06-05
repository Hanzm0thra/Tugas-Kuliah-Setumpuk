package projectakhir.note.app.core.data.note;

import java.util.List;

public interface NoteDao {

    void insert(String title, String content, String date, String author);
    void delete(Integer id);
    void update(Integer id, String title, String content, String date, String author);
    List<NoteEntity> getAllNotes(String author);
    boolean isIdExist(Integer id, String author);
}
