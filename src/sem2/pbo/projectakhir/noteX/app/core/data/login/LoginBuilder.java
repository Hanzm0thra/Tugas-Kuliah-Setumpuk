package sem2.pbo.projectakhir.noteX.app.core.data.login;

public class LoginBuilder extends LoginDB {
    private static LoginDB INSTANCE;

    public static LoginDB getInstance() {
        if (INSTANCE == null)
            INSTANCE = new LoginBuilder().loginBuild();
        return INSTANCE;
    }


}
