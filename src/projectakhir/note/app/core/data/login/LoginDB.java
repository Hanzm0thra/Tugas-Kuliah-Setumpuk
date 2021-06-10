package projectakhir.note.app.core.data.login;

import java.util.ArrayList;
import java.util.List;

public class LoginDB implements LoginDao {

    private List<LoginEntity> loginCollection = new ArrayList<>();

    public LoginDB() {
        addListOfUser();
    }

    public void addListOfUser() {
        loginCollection.add(
                new LoginEntity(
                        "akunbaru@gmail.com",
                        "12345",
                        "Master Mail"
                )
        );

        loginCollection.add(
                new LoginEntity(
                        "officialNote@gmail.com",
                        "12345",
                        "Official Note"
                )
        );

        loginCollection.add(
                new LoginEntity(
                        "a",
                        "1",
                        "a"
                )
        );

        loginCollection.add(
                new LoginEntity(
                        "usertest@gmail.com",
                        "testing123",
                        "user test"
                )
        );

        loginCollection.add(
                new LoginEntity(
                        "example@gmail.com",
                        "example12345",
                        "example user"
                )
        );
    }

    @Override
    public LoginEntity getAccount(String email, String password) {
        LoginEntity result = new LoginEntity(null, null, null);

        for (LoginEntity loginEntity : loginCollection) {
            if (loginEntity.email().equals(email) && loginEntity.password().equals(password)) {
                result = new LoginEntity(
                        loginEntity.email(),
                        loginEntity.password(),
                        loginEntity.name()
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
                    new LoginEntity(
                            email,
                            password,
                            name
                    )
            );
    }

    @Override
    public String getName(String name) {
        for (LoginEntity obj: loginCollection) {
            if (obj.name().equals(name))
                return name;
        }
        return null;
    }

    @Override
    public String getEmail(String email) {
        for (LoginEntity obj: loginCollection) {
            if (obj.email().equals(email))
                return email;
        }
        return null;
    }
}
