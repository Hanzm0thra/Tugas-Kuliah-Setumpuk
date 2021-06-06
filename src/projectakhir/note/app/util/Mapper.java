package projectakhir.note.app.util;


import projectakhir.note.app.core.data.login.LoginResponse;
import projectakhir.note.app.core.data.note.NoteEntity;
import projectakhir.note.app.model.Login;
import projectakhir.note.app.model.Note;

import java.util.List;
import java.util.stream.Collectors;

public class Mapper {

    public static Login mappingLogin(LoginResponse loginResponse) {
        return new Login(
                loginResponse.email(),
                loginResponse.password(),
                loginResponse.name()
        );
    }

    public static List<Note> mappingNotes(List<NoteEntity> noteEntities) {
        return noteEntities.stream().map(
                noteEntity -> new Note(
                        noteEntity.id(),
                        noteEntity.title(),
                        noteEntity.content(),
                        noteEntity.date(),
                        noteEntity.author()
                )
        ).collect(Collectors.toList());
    }

    public static Note mappingNote(NoteEntity noteEntity) {
        return new Note(
                noteEntity.id(),
                noteEntity.title(),
                noteEntity.content(),
                noteEntity.date(),
                noteEntity.author()
        );
    }
}
