package projectakhir.note.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import projectakhir.note.app.core.repository.NoteRepository;
import projectakhir.note.app.di.Injection;

@RunWith(JUnit4.class)
public class RepositoryTest {

    private NoteRepository noteRepository;

    @Before
    public void setup() {
        noteRepository = new NoteRepository(Injection.provideLoginDataSource, Injection.provideNoteDataSource);
    }

    @Test
    public void testGetAccount() {

    }

}
