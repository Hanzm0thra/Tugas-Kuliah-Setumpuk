package sem2.pbo.projectakhir.movie.app.core.data.login;

public class UserBuilder extends UserDB{

    private static UserDB INSTANCE;

    public static UserDB getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new UserDB();
        }
        return INSTANCE;
    }
}
