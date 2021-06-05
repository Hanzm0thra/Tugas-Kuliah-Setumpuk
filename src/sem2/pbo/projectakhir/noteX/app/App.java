package sem2.pbo.projectakhir.noteX.app;

import sem2.pbo.projectakhir.noteX.app.di.Injection;
import sem2.pbo.projectakhir.noteX.app.model.Login;
import sem2.pbo.projectakhir.noteX.app.ui.HomeView;
import sem2.pbo.projectakhir.noteX.app.ui.LoginView;

public class App {

    private static LoginView loginView = Injection.provideLoginView;
    private static HomeView homeView = Injection.provideHomeView;

    public static void main(String[] args) {

        System.out.println("\t\t\t\tWelcome To Note App\t\t\t\t\t\n");
        Login account = loginView.login();
        String author = account.name();

        homeView.home(author);
    }
}
