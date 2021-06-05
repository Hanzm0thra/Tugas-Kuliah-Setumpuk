package projectakhir.note.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import projectakhir.note.app.core.data.login.LoginDB;

@RunWith(JUnit4.class)
public class TestLoginDB {

    private LoginDB loginDB;

    @Before
    public void setup() {
        loginDB = new LoginDB();
    }

    @Test
    public void registerFlowTest() {
        String email = "kylixeza@student.ub.ac.id";
        String password = "100902";
        String name = "kylix";

        isEmailExist(email);
        isNameExist(name);
        register(email, password, name);
        isEmailExist(email);
        isNameExist(name);
        accountExist(email, password);
    }


    private void accountExist(String email, String password) {
        if (loginDB.getAccount(email, password).email() == null)
            Assertions.assertNull(loginDB.getAccount(email, password).email());
        else
            Assertions.assertEquals(email, loginDB.getAccount(email, password).email());
    }

    private void isEmailExist(String email) {
        if (loginDB.isEmailAlreadyExist(email))
            Assertions.assertEquals(email, loginDB.getEmail(email));
        else
            Assertions.assertNull(loginDB.getEmail(email));
    }

    private void isNameExist(String name) {
        if (loginDB.isNameAlreadyExist(name))
            Assertions.assertEquals(name, loginDB.getName(name));
        else
            Assertions.assertNull(loginDB.getName(name));
    }

    private void register(String email, String password, String name) {
        loginDB.register(email, password, name);
    }
}
