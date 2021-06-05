package projectakhir.note.app.core.data.login;

import java.util.ArrayList;
import java.util.List;

public class LoginDB implements LoginClient{

    private List<LoginResponse> loginCollection = new ArrayList<>();

    public LoginDB() {
        addListOfUser();
    }

    public void addListOfUser() {
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
    }

    @Override
    public LoginResponse getAccount(String email, String password) {
        LoginResponse result = new LoginResponse(null, null, null);

        for (LoginResponse loginResponse : loginCollection) {
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
        return loginCollection
                .stream().anyMatch(loginResponse -> loginResponse.email().equals(email));
    }

    @Override
    public boolean isNameAlreadyExist(String name) {
        return loginCollection
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

    @Override
    public String getName(String name) {
        for (LoginResponse obj: loginCollection) {
            if (obj.name().equals(name))
                return name;
        }
        return null;
    }

    @Override
    public String getEmail(String email) {
        for (LoginResponse obj: loginCollection) {
            if (obj.email().equals(email))
                return email;
        }
        return null;
    }
}
