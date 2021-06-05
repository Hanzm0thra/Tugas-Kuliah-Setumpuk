package sem2.pbo.projectakhir.note.app.core.data.login;

public class LoginBuilder extends LoginDB {
    private static LoginDB INSTANCE;

    public static LoginDB getInstance() {
        if (INSTANCE == null)
            INSTANCE = new LoginDB();
        return INSTANCE;
    }
}
