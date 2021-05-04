package sem2.pbo.projectakhir.note.test.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sem2.pbo.projectakhir.note.test.di.FakeInjection;

public class TestLoginDB {

    static FakeLoginDB testLogin = FakeInjection.provideFakeLoginDB;

    @Test
    public void loginAttributeTest() {
        accountExist("budi", "sari");
        accountExist("usertest@gmail.com", "testing123");
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
    }

    private void accountExist(String email, String password) {
        if (testLogin.getAccount(email, password).email() == null)
            Assertions.assertNull(testLogin.getAccount(email, password).email());
        else
            Assertions.assertEquals(email, testLogin.getAccount(email, password).email());
    }

    private void isEmailExist(String email) {
        if (testLogin.isEmailAlreadyExist(email))
            Assertions.assertEquals(email, testLogin.getEmail(email));
        else
            Assertions.assertNull(testLogin.getEmail(email));
    }

    private void isNameExist(String name) {
        if (testLogin.isNameAlreadyExist(name))
            Assertions.assertEquals(name, testLogin.getName(name));
        else
            Assertions.assertNull(testLogin.getName(name));
    }

    private void register(String email, String password, String name) {
        testLogin.register(email, password, name);
    }
}
