package sem2.pbo.projectakhir.noteX.test.login;

import sem2.pbo.projectakhir.noteX.app.core.data.login.LoginDB;
import sem2.pbo.projectakhir.noteX.app.core.data.login.LoginResponse;

public class FakeLoginDB extends LoginDB {

    @Override
    public LoginResponse getAccount(String email, String password) {
        return super.getAccount(email, password);
    }

    @Override
    public boolean isEmailAlreadyExist(String email) {
        return super.isEmailAlreadyExist(email);
    }

    @Override
    public boolean isNameAlreadyExist(String name) {
        return super.isNameAlreadyExist(name);
    }

    @Override
    public void register(String email, String password, String name) {
        super.register(email, password, name);
    }

    public String getName(String name) {
        for (LoginResponse obj: getLoginList()) {
            if (obj.name().equals(name))
                return name;
        }
        return null;
    }

    public String getEmail(String email) {
        for (LoginResponse obj: getLoginList()) {
            if (obj.email().equals(email))
                return email;
        }
        return null;
    }
}
