package sem2.pbo.projectakhir.movie.app.core.data;

import sem2.pbo.projectakhir.movie.app.core.data.user.IUserDB;
import sem2.pbo.projectakhir.movie.app.core.data.user.UserEntity;

public class UserDataSource {
    private IUserDB userDB;

    public UserDataSource(IUserDB userDB) {
        this.userDB = userDB;
    }

    public UserEntity getAllUsers(String email, String password) {
        return userDB.getAllUsers(email, password);
    }

    public boolean isNameAlreadyExist(String name) {
        return userDB.isNameAlreadyExist(name);
    }

    public boolean isEmailAlreadyExist(String email) {
        return userDB.isEmailAlreadyExist(email);
    }

    public void register(String name, String email, String password ) {
        userDB.register(name, email, password);
    }
}
