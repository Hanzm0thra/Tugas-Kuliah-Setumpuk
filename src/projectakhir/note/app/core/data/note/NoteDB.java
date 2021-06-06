package projectakhir.note.app.core.data.note;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;

import java.util.ArrayList;
import java.util.List;

public class NoteDB implements NoteDao {

    private List<NoteEntity> notes = new ArrayList<>();

    @Override
    public void insert(String title, String content, String date, String author) {
        String id = NanoIdUtils.randomNanoId();
        notes.add(new NoteEntity(
                id,
                title,
                content,
                date,
                author
        ));
    }

    @Override
    public void delete(String id) {
        notes.removeIf(obj -> obj.id().equals(id));
    }

    @Override
    public void update(String id, String title, String content, String date, String author) {
        for (int index = 0; index < notes.size(); index++) {
            if (notes.get(index).id().equals(id)) {
                notes.set(index, new NoteEntity(
                        notes.get(index).id(),
                        title,
                        content,
                        date,
                        author
                ));
            }
        }
    }

    @Override
    public List<NoteEntity> getAllNotes(String author) {
        List<NoteEntity> selectedNote = new ArrayList<>();

        for (NoteEntity obj: notes) {
            if (obj.author().equals(author))
                selectedNote.add(obj);
        }

        return selectedNote;
    }

    @Override
    public NoteEntity getSelectedNote(String id) {
        NoteEntity noteEntity = new NoteEntity(null, null, null, null, null);

        for (NoteEntity obj: notes) {
            if (obj.id().equals(id))
                noteEntity = new NoteEntity(
                        obj.id(),
                        obj.title(),
                        obj.content(),
                        obj.date(),
                        obj.author()
                );
        }

        return noteEntity;
    }

    @Override
    public boolean isIdExist(String id, String author) {
        boolean isExist = false;

        for (NoteEntity obj: notes) {
            if (obj.id().equals(id) && obj.author().equals(author)) {
                isExist = true;
                break;
            }
        }
        return isExist;
    }

    public List<NoteEntity> getNotes() {
        return notes;
    }
}
