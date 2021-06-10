package projectakhir.note.app.core.data.login;

public interface LoginDao {

    LoginEntity getAccount(String email, String password);
    boolean isEmailAlreadyExist(String email);
    boolean isNameAlreadyExist(String password);
    void register(String email, String password, String name);
    String getName(String name);
    String getEmail(String email);
}
