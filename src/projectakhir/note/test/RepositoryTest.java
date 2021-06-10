package projectakhir.note.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import projectakhir.note.app.core.data.LoginDataSource;
import projectakhir.note.app.core.data.NoteDataSource;
import projectakhir.note.app.core.data.login.LoginDB;
import projectakhir.note.app.core.data.login.LoginEntity;
import projectakhir.note.app.core.data.note.NoteDB;
import projectakhir.note.app.core.data.note.NoteEntity;
import projectakhir.note.app.core.repository.NoteRepository;
import projectakhir.note.app.model.Login;
import projectakhir.note.app.model.Note;

import java.util.List;

@RunWith(JUnit4.class)
public class RepositoryTest {

    private NoteRepository noteRepository;
    private NoteDB noteDB;
    private LoginDB loginDB;

    @Before
    public void setup() {
        noteDB = new NoteDB();
        loginDB = new LoginDB();

        NoteDataSource noteDataSource = new NoteDataSource(noteDB);
        LoginDataSource loginDataSource = new LoginDataSource(loginDB);

        noteRepository = new NoteRepository(loginDataSource, noteDataSource);
    }

    @Test
    public void testGetAccount() {
        insertUser();
        Login userLogin = new Login("loilyxtra@gmail.com", "100902", "Kylix Eza");
        LoginEntity userLoginEntity = new LoginEntity("loilyxtra@gmail.com", "100902", "Kylix Eza");
        Login userRepository = noteRepository.getAccount("loilyxtra@gmail.com", "100902");

        Assertions.assertEquals(userLogin, userRepository);
        Assertions.assertEquals(userLoginEntity.email(), userRepository.email());
        Assertions.assertEquals(userLoginEntity.name(), userRepository.name());
        Assertions.assertEquals(userLoginEntity.password(), userRepository.password());
    }

    @Test
    public void testGetAllNotes() {
        insertNotes();
        List<NoteEntity> expectedNotes = noteDB.getAllNotes("Kylix Eza");
        List<Note> actualNotes = noteRepository.getAllNotes("Kylix Eza");

        Assertions.assertEquals(expectedNotes.size(), actualNotes.size());
        Assertions.assertEquals(expectedNotes.get(0).id(), actualNotes.get(0).id());
        Assertions.assertEquals(expectedNotes.get(1).id(), actualNotes.get(1).id());
    }

    @Test
    public void testSelectedNote() {
        insertNotes();
        List<NoteEntity> expectedNotes = noteDB.getAllNotes("Kylix Eza");
        List<Note> actualNotes = noteRepository.getAllNotes("Kylix Eza");

        NoteEntity expectedNote1 = noteDB.getSelectedNote(expectedNotes.get(0).id());
        NoteEntity expectedNote2 = noteDB.getSelectedNote(expectedNotes.get(1).id());

        Note actualNote1 = noteRepository.getSelectedNote(actualNotes.get(0).id());
        Note actualNote2 = noteRepository.getSelectedNote(actualNotes.get(1).id());

        Assertions.assertNotEquals(expectedNote1, expectedNote2);
        Assertions.assertNotEquals(actualNote1, actualNote2);

        Assertions.assertEquals(expectedNote1.id(), actualNote1.id());
        Assertions.assertEquals(expectedNote2.id(), actualNote2.id());
        Assertions.assertEquals(expectedNote1.title(), actualNote1.title());
        Assertions.assertEquals(expectedNote2.title(), actualNote2.title());
    }

    private void insertUser() {
        loginDB.register("loilyxtra@gmail.com", "100902", "Kylix Eza");
    }

    private void insertNotes() {
        noteDB.insert("Test Note 1", "Content Test Note 1", "1-1-1", "Kylix Eza");
        noteDB.insert("Test Note 2", "Content Test Note 2", "2-2-2", "Kylix Eza");
    }
}
