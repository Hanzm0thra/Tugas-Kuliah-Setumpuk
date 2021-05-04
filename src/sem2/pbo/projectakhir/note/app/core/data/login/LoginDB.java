package sem2.pbo.projectakhir.note.app.core.data.login;

import java.util.ArrayList;
import java.util.List;

public class LoginDB implements LoginClient{

    private List<LoginResponse> loginCollection = new ArrayList<>();

    private List<LoginResponse> listAllUsers() {
        loginCollection.add(
                new LoginResponse(
                        "akunbaru@gmail.com",
                        "12345",
                        "Master Mail"
                )
        );

        loginCollection.add(
                new LoginResponse(
                        "officialNote@gmail.com",
                        "12345",
                        "Official Note"
                )
        );

        loginCollection.add(
                new LoginResponse(
                        "a",
                        "1",
                        "a"
                )
        );

        loginCollection.add(
                new LoginResponse(
                        "usertest@gmail.com",
                        "testing123",
                        "user test"
                )
        );

        return loginCollection;
    }

    @Override
    public LoginResponse getAccount(String email, String password) {
        LoginResponse result = new LoginResponse(null, null, null);

        for (LoginResponse loginResponse : listAllUsers()) {
            if (loginResponse.email().equals(email) && loginResponse.password().equals(password)) {
                result = new LoginResponse(
                        loginResponse.email(),
                        loginResponse.password(),
                        loginResponse.name()
                );
            }
        }

        return result;
    }

    @Override
    public boolean isEmailAlreadyExist(String email) {
        return listAllUsers()
                .stream().anyMatch(loginResponse -> loginResponse.email().equals(email));
    }

    @Override
    public boolean isNameAlreadyExist(String name) {
        return listAllUsers()
                .stream().anyMatch(loginResponse -> loginResponse.name().equals(name));
    }

    @Override
    public void register(String email, String password, String name) {
        if (!isEmailAlreadyExist(email) && !isNameAlreadyExist(name))
            loginCollection.add(
                    new LoginResponse(
                            email,
                            password,
                            name
                    )
            );
    }

    public List<LoginResponse> getLoginCollection() {
        return loginCollection;
    }
}
