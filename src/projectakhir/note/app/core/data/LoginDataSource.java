package projectakhir.note.app.core.data;

import projectakhir.note.app.core.data.login.LoginDao;
import projectakhir.note.app.core.data.login.LoginEntity;

public class LoginDataSource {

    private static LoginDataSource INSTANCE;

    private LoginDao LoginDao;

    public static LoginDataSource getInstance(LoginDao LoginDao) {
        if (INSTANCE == null)
            INSTANCE = new LoginDataSource(LoginDao);
        return INSTANCE;
    }

    public LoginDataSource(LoginDao LoginDao) {
        this.LoginDao = LoginDao;
    }

    public LoginEntity getAccount(String email, String password) {
        return LoginDao.getAccount(email, password);
    }

    public boolean isEmailAlreadyExist(String email) {
        return LoginDao.isEmailAlreadyExist(email);
    }

    public boolean isNameAlreadyExist(String name) {
        return LoginDao.isNameAlreadyExist(name);
    }

    public void register(String email, String password, String name) {
        LoginDao.register(email, password, name);
    }
}
