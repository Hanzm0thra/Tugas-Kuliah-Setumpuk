package sem2.pbo.projectakhir.movie.app.core.data.user;

public interface IUserDB {
    UserEntity getAllUsers(String email, String password);
    boolean isNameAlreadyExist(String name);
    boolean isEmailAlreadyExist(String email);
    void register(String name, String email, String password );
}
