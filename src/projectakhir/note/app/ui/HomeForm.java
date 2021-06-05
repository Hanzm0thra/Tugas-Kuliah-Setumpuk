package projectakhir.note.app.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projectakhir.note.app.di.Injection;

public class HomeForm extends Application {

    private Text textAuthor;

    private Button btnNewNote;
    private Button btnAllNotes;
    private Button btnLogout;

    public static String argAccountName;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initButtonNewNote(primaryStage);
        initButtonAllNotes();
        initButtonLogout(primaryStage);
        initTextWelcome();

        VBox vBoxAllButton = new VBox(25, btnNewNote, btnAllNotes, btnLogout);
        vBoxAllButton.setLayoutX(150);
        vBoxAllButton.setLayoutY(135);

        Group root = new Group(textAuthor, vBoxAllButton);

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public void initTextWelcome() {
        textAuthor = new Text();
        textAuthor.setText("Author: " + argAccountName);
        textAuthor.setX(50);
        textAuthor.setY(50);
        textAuthor.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
    }

    private void initButtonNewNote(Stage stage) {
        btnNewNote = new Button();
        btnNewNote.setText("Add New Note");
        btnNewNote.setPrefSize(200, 75);
        btnNewNote.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NewNoteForm newNoteForm = new NewNoteForm();
                newNoteForm.start(stage);
            }
        });
    }

    private void initButtonAllNotes() {
        btnAllNotes = new Button();
        btnAllNotes.setText("All Notes");
        btnAllNotes.setPrefSize(200, 75);
    }

    private void initButtonLogout(Stage stage) {
        btnLogout = new Button();
        btnLogout.setText("Logout");
        btnLogout.setPrefSize(200, 75);
        btnLogout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginForm loginForm = new LoginForm();
                loginForm.start(stage);
            }
        });
    }
}
