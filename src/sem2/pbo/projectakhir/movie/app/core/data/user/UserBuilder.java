package sem2.pbo.projectakhir.movie.app.core.data.user;

public class UserBuilder extends UserDB{

    private static UserBuilder INSTANCE;

    public static UserBuilder getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new UserBuilder();
        }
        return INSTANCE;
    }
}
