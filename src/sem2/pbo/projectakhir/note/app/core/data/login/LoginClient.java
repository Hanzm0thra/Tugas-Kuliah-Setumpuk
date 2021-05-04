package sem2.pbo.projectakhir.note.app.core.data.login;

public interface LoginClient {

    LoginResponse getAccount(String email, String password);
    boolean isEmailAlreadyExist(String email);
    boolean isNameAlreadyExist(String password);
    void register(String email, String password, String name);
}
