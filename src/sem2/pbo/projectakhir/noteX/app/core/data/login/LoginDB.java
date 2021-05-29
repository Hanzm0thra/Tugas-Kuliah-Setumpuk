package sem2.pbo.projectakhir.noteX.app.core.data.login;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoginDB implements LoginClient {

    private List<LoginResponse> loginList = new ArrayList<>();

    @Override
    public LoginResponse getAccount(String email, String password) {
        LoginResponse result = new LoginResponse(null, null, null);

        for (LoginResponse loginResponse : loginList) {
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
        return loginList
                .stream().anyMatch(loginResponse -> loginResponse.email().equals(email));
    }

    @Override
    public boolean isNameAlreadyExist(String name) {
        return loginList
                .stream().anyMatch(loginResponse -> loginResponse.name().equals(name));
    }

    @Override
    public void register(String email, String password, String name) {
        if (!isEmailAlreadyExist(email) && !isNameAlreadyExist(name)) {
            File loginFile = new File("D:\\Materi Kuliah\\Sem 2\\PBO\\Project Akhir\\Login Account.txt");
            try {
                FileWriter writer = new FileWriter(loginFile);
                String data = email + "-" + password + "-" + name;
                writer.write(data + "\n");
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            loginList.add(
                    new LoginResponse(
                            email,
                            password,
                            name
                    )
            );
    }

    public LoginDB build() {
        try {
            File loginFile = new File("D:\\Materi Kuliah\\Sem 2\\PBO\\Project Akhir\\Login Account.txt");
            if (!loginFile.exists())
                loginFile.createNewFile();

            Scanner read = new Scanner(loginFile);
            while (read.hasNextLine())
                fileBreakdown(read.nextLine());

            read.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new LoginDB();
    }

    private void fileBreakdown(String data) {
        String[] arr = data.split("[-\n]");
        loginList.add(new LoginResponse(
                arr[0],
                arr[1],
                arr[2]
        ));
    }

    public List<LoginResponse> getLoginList() {
        return loginList;
    }
}
