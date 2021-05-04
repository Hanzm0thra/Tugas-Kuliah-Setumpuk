package sem2.pbo.projectakhir.note.app.ui;

import sem2.pbo.projectakhir.note.app.core.repository.INoteRepository;
import sem2.pbo.projectakhir.note.app.model.Login;

import java.util.Scanner;

public class LoginView {

    private INoteRepository noteRepository;

    public LoginView(INoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Login login() {
        Scanner scanner = new Scanner(System.in);
        boolean isFinished = false;
        Login account = null;

        System.out.println("................ Login Section .................");

        do {

            System.out.println("\n1. Login");
            System.out.println("2. Register");
            System.out.print("Masukkan pilihan: ");
            String _choose = scanner.nextLine().trim();
            int choose;
            try {
                choose = Integer.parseInt(_choose);
            } catch (Exception e) {
                choose = 0;
            }


            switch (choose) {
                case 1 -> {
                    account = auth();
                    if (account.email() != null) {
                        isFinished = true;
                    }
                }
                case 2 -> {
                    System.out.print("Isikan nama pengguna: ");
                    String name = scanner.nextLine().trim();
                    if (noteRepository.isNameAlreadyExist(name)) {
                        System.out.println("Register gagal karena nama pengguna sudah digunakan");
                        isFinished = false;
                        break;
                    }
                    System.out.print("Isikan email: ");
                    String email = scanner.nextLine().trim();
                    if (noteRepository.isEmailAlreadyExist(email)) {
                        System.out.println("Register gagal karena email sudah digunakan");
                        isFinished = false;
                        break;
                    }

                    System.out.print("Isikan password: ");
                    String password = scanner.nextLine().trim();
                    noteRepository.register(email, password, name);
                }
                default -> System.out.println("Input Tidak Valid");
            }
        }while (!isFinished);

        System.out.println("................................................");
        return account;
    }

    private Login auth() {
        Login account;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        account = noteRepository.getAccount(email, password);

        if (account.email() == null) {
            System.out.println("Mohon maaf akun tidak ditemukan");
        } else {
            System.out.println("Welcome " + account.name());
        }
        return account;
    }
}
