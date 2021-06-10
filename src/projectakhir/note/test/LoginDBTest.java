package projectakhir.note.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import projectakhir.note.app.core.data.login.LoginDB;

@RunWith(JUnit4.class)
public class LoginDBTest {

    private LoginDB loginDBImpl;

    @Before
    public void setup() {
        loginDBImpl = new LoginDB();
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
        if (loginDBImpl.getAccount(email, password).email() == null)
            Assertions.assertNull(loginDBImpl.getAccount(email, password).email());
        else
            Assertions.assertEquals(email, loginDBImpl.getAccount(email, password).email());
    }

    private void isEmailExist(String email) {
        if (loginDBImpl.isEmailAlreadyExist(email))
            Assertions.assertEquals(email, loginDBImpl.getEmail(email));
        else
            Assertions.assertNull(loginDBImpl.getEmail(email));
    }

    private void isNameExist(String name) {
        if (loginDBImpl.isNameAlreadyExist(name))
            Assertions.assertEquals(name, loginDBImpl.getName(name));
        else
            Assertions.assertNull(loginDBImpl.getName(name));
    }

    private void register(String email, String password, String name) {
        loginDBImpl.register(email, password, name);
    }
}
