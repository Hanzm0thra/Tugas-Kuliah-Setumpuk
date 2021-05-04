package sem2.pbo.projectakhir.note.test.note;

import sem2.pbo.projectakhir.note.app.core.data.note.NoteDB;
import sem2.pbo.projectakhir.note.app.core.data.note.NoteEntity;

import java.util.List;

public class FakeNoteDB extends NoteDB {

    @Override
    public void insert(String title, String content, String date, String author) {
        super.insert(title, content, date, author);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

    @Override
    public void update(Integer id, String title, String content, String date, String author) {
        super.update(id, title, content, date, author);
    }

    @Override
    public List<NoteEntity> getAllNotes(String author) {
        return super.getAllNotes(author);
    }

    @Override
    public boolean isIdExist(Integer id, String author) {
        return super.isIdExist(id, author);
    }
}
