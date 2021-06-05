package sem2.pbo.projectakhir.note.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import sem2.pbo.projectakhir.note.app.core.repository.NoteRepository;
import sem2.pbo.projectakhir.note.app.di.Injection;

@RunWith(MockitoJUnitRunner.class)
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
