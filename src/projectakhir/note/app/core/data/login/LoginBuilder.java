package projectakhir.note.app.core.data.login;

public class LoginBuilder extends LoginDB {
    private static LoginBuilder INSTANCE;

    LoginBuilder() {
        super();
    }

    public static LoginBuilder getInstance() {
        if (INSTANCE == null)
            INSTANCE = new LoginBuilder();
        return INSTANCE;
    }
}
