package projectakhir.note.app;

import javafx.application.Application;
import javafx.stage.Stage;
import projectakhir.note.app.ui.LoginForm;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        LoginForm loginForm = new LoginForm();
        loginForm.start(primaryStage);
    }
}
