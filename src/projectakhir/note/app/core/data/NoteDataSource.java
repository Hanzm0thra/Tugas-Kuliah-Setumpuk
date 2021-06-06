package projectakhir.note.app.core.data;

import projectakhir.note.app.core.data.note.NoteDao;
import projectakhir.note.app.core.data.note.NoteEntity;

import java.util.List;

public class NoteDataSource {

    private NoteDao noteDao;

    public NoteDataSource(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public void insert(String title, String content, String date, String author) {
        noteDao.insert(title, content, date, author);
    }

    public void delete(String id) {
        noteDao.delete(id);
    }

    public void update(String id, String title, String content, String date, String author) {
        noteDao.update(id, title, content, date, author);
    }

    public List<NoteEntity> getAllNotes(String author) {
        return noteDao.getAllNotes(author);
    }

    public NoteEntity getSelectedNote(String id) {
        return noteDao.getSelectedNote(id);
    }

    public boolean isIdExist(String id, String author) {
        return noteDao.isIdExist(id, author);
    }
}
