package sem2.pbo.projectakhir.note.app.core.data;

import sem2.pbo.projectakhir.note.app.core.data.note.NoteDao;
import sem2.pbo.projectakhir.note.app.core.data.note.NoteEntity;

import java.util.List;

public class NoteDataSource {

    private NoteDao noteDao;

    public NoteDataSource(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    public void insert(String title, String content, String date, String author) {
        noteDao.insert(title, content, date, author);
    }

    public void delete(Integer id) {
        noteDao.delete(id);
    }

    public void update(Integer id, String title, String content, String date, String author) {
        noteDao.update(id, title, content, date, author);
    }

    public List<NoteEntity> getAllNotes(String author) {
        return noteDao.getAllNotes(author);
    }

    public boolean isIdExist(Integer id, String author) {
        return noteDao.isIdExist(id, author);
    }
}
