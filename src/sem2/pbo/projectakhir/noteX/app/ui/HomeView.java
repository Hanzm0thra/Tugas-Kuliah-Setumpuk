package sem2.pbo.projectakhir.noteX.app.ui;

import sem2.pbo.projectakhir.noteX.app.core.repository.INoteRepository;
import sem2.pbo.projectakhir.noteX.app.model.Login;
import sem2.pbo.projectakhir.noteX.app.model.Note;

import java.util.List;
import java.util.Scanner;

public class HomeView {

    private INoteRepository noteRepository;
    private LoginView loginView;
    private Scanner scanner = new Scanner(System.in);

    public HomeView(INoteRepository noteRepository, LoginView loginView) {
        this.noteRepository = noteRepository;
        this.loginView = loginView;
    }

    public void home(String author) {
        boolean isLoop = true;
         do {
             System.out.println("\n================ List Of Notes ===============");
             System.out.println("Author: " + author + "\n");
             List<Note> listNotes = noteRepository.getAllNotes(author);
             if (listNotes.size() != 0)
                 showList(listNotes);
             else {
                 System.out.println("Masih belum ada note yang ditambahkan\n");
                 System.out.println("==============================================\n");
             }
             System.out.println("1. Buat note baru");
             System.out.println("2. Hapus note");
             System.out.println("3. Update note");
             System.out.println("4. Logout");
             System.out.println("5. Tutup program");
             System.out.print("Masukkan pilihan: ");
             int choose = 0;
             try {
                 String _choose = scanner.nextLine();
                 choose = Integer.parseInt(_choose);
             } catch (Exception e) {
                 System.out.println("Input yang dimasukan tidak valid");
             }

             switch (choose) {
                 case 1 -> createNewNote(author);
                 case 2 -> deleteNote(author);
                 case 3 -> updateNote(author);
                 case 4 -> {
                     isLoop = false;
                     logout();
                 }
                 case 5 -> isLoop = false;
             }
         } while (isLoop);
    }

    private void createNewNote(String author) {
        System.out.print("\nMasukkan judul note: ");
        String title = scanner.nextLine();

        System.out.println("Masukkan deskripsi note: ");
        String content = multiLineInput();

        System.out.println("Deadline");
        System.out.print("Masukkan tanggal(DD): ");
        String date = scanner.nextLine();
        System.out.print("Masukkan bulan(MM): ");
        String month = scanner.nextLine();
        System.out.print("Masukkan tahun(YYYY): ");
        String year = scanner.nextLine();
        String dueDate = String.format("%s-%s-%s", date, month, year);

        noteRepository.insert(title, content, dueDate, author);
    }

    private void deleteNote(String author) {
        System.out.print("Masukkan id note yang akan dihapus: ");
        String _id = scanner.nextLine();
        try {
            int id = Integer.parseInt(_id);
            boolean isExist = noteRepository.isIdExist(id, author);

            if (isExist)
                noteRepository.delete(id);
            else
                System.out.println("Id tidak ditemukan");

        } catch (NumberFormatException nfe) {
            System.out.println("Input tidak valid");
        }
    }

    private void updateNote(String author) {
        System.out.print("Masukkan id note yang akan dihapus: ");
        String _id = scanner.nextLine();

        try {
            int id = Integer.parseInt(_id);
            boolean isExist = noteRepository.isIdExist(id, author);

            if (isExist){
                System.out.print("\nMasukkan judul note: ");
                String title = scanner.nextLine();

                System.out.println("Masukkan deskripsi note: ");
                String content = multiLineInput();

                System.out.println("Deadline");
                System.out.print("Masukkan tanggal(DD): ");
                String date = scanner.nextLine();
                System.out.print("Masukkan bulan(MM): ");
                String month = scanner.nextLine();
                System.out.print("Masukkan tahun(YYYY): ");
                String year = scanner.nextLine();
                String dueDate = String.format("%s-%s-%s", date, month, year);

                noteRepository.update(id, title, content, dueDate, author);
            }
            else
                System.out.println("Id tidak ditemukan");

        } catch (NumberFormatException nfe) {
            System.out.println("Input tidak valid");
        }

    }

    private void logout() {
        System.out.println("\nSee You Later ^_^\n");

        Login account = loginView.login();
        String author = account.name();
        home(author);
    }

    private String multiLineInput() {
        String text = "";
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if ("".equals(input))
                break;
            text = text.concat("\n").concat(input) ;
        }
        return text;
    }

    private void showList(List<Note> list) {
        for (Note obj: list) {
            System.out.println("Id: " + obj.id());
            System.out.println("Judul: " + obj.title());
            System.out.println("Deskirpsi: " + obj.content());
            System.out.println("Deadline: " + obj.date());
            System.out.println();
        }
        System.out.println("==============================================\n");
    }
}
