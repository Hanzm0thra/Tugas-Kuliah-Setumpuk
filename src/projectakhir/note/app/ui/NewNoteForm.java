package projectakhir.note.app.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projectakhir.note.app.core.repository.INoteRepository;
import projectakhir.note.app.di.Injection;

public class NewNoteForm extends Application {

    private Text textTitle;
    private Text textContent;
    private Text textDeadline;
    private Text textDate;
    private Text textMonth;
    private Text textYear;
    private Text textAuthor;

    private TextField tfTitle;
    private TextArea taContent;
    private TextField tfDate;
    private TextField tfMonth;
    private TextField tfYear;

    private Button btnAddNote;
    private Button btnBack;

    private final INoteRepository noteRepository = Injection.provideNoteRepository;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initTextTitle();
        initTextContent();
        initTextDeadline();
        initTextDate();
        initTextMonth();
        initTextYear();
        initTextAuthor();

        initTextFieldTitle();
        initTextAreaContent();
        initTextFieldDate();
        initTextFieldMonth();
        initTextFieldYear();

        initButtonAddNote();
        initButtonBack(primaryStage);

        VBox vBoxTextTitleContent = new VBox(28, textTitle, textContent);
        VBox vBoxTextFieldTitleContent = new VBox(20, tfTitle, taContent);
        HBox hBoxTitleContent = new HBox(35, vBoxTextTitleContent, vBoxTextFieldTitleContent);

        VBox vBoxTextDeadline = new VBox(28, textDate, textMonth, textYear);
        VBox vBoxTextFieldDeadline = new VBox(20, tfDate, tfMonth, tfYear);
        HBox hBoxDeadline = new HBox(35, vBoxTextDeadline, vBoxTextFieldDeadline);
        VBox vBoxDeadline = new VBox(20,textDeadline, hBoxDeadline);

        VBox vBoxAddNote = new VBox(25, hBoxTitleContent, vBoxDeadline, btnAddNote);
        vBoxAddNote.setLayoutX(50);
        vBoxAddNote.setLayoutY(100);

        Group root = new Group(textAuthor, vBoxAddNote, btnBack);
        Scene scene = new Scene(root, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initTextTitle() {
        textTitle = new Text();
        textTitle.setText("Title");
        textTitle.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextContent() {
        textContent = new Text();
        textContent.setText("Description");
        textContent.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextDeadline() {
        textDeadline = new Text();
        textDeadline.setText("Deadline");
        textDeadline.setFont(Font.font("Calibri", FontWeight.BOLD, 22));
    }

    private void initTextDate() {
        textDate = new Text();
        textDate.setText("Date(DD)");
        textDate.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextMonth() {
        textMonth = new Text();
        textMonth.setText("Month(MM)");
        textMonth.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextYear() {
        textYear = new Text();
        textYear.setText("Year(YYYY)");
        textYear.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    public void initTextAuthor() {
        textAuthor = new Text();
        textAuthor.setText("Author: " + HomeForm.argAccountName);
        textAuthor.setX(50);
        textAuthor.setY(50);
        textAuthor.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
    }

    private void initTextFieldTitle() {
        tfTitle = new TextField();
    }

    private void initTextAreaContent() {
        taContent = new TextArea();
    }

    private void initTextFieldDate() {
        tfDate = new TextField();
    }

    private void initTextFieldMonth() {
        tfMonth = new TextField();
    }

    private void initTextFieldYear() {
        tfYear = new TextField();
    }

    private void initButtonAddNote() {
        btnAddNote = new Button();
        btnAddNote.setText("Confirm");
        btnAddNote.setPrefSize(250, 50);
        btnAddNote.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dialog<String> dialog = new Dialog<String>();
                ButtonType btnOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().add(btnOK);

                String title = tfTitle.getText();
                String content = taContent.getText();
                String date = tfDate.getText();
                String month = tfMonth.getText();
                String year = tfYear.getText();
                String deadline = String.format("%s-%s-%s", date, month, year);
                String author = HomeForm.argAccountName;

                if (title.isEmpty() || content.isEmpty() || date.isEmpty() || month.isEmpty() || year.isEmpty()) {
                    dialog.setContentText("Data belum lengkap, silahkan dilengkapi");
                    dialog.showAndWait();
                } else {
                    noteRepository.insert(title, content, deadline, author);
                    dialog.setContentText("Note telah ditambahkan");
                    dialog.showAndWait();
                    clear();
                }
            }
        });
    }

    private void initButtonBack(Stage stage) {
        btnBack = new Button();
        btnBack.setText("Back");
        btnBack.setLayoutX(25);
        btnBack.setLayoutY(650);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HomeForm homeForm = new HomeForm();
                homeForm.start(stage);
            }
        });
    }

    private void clear() {
        tfTitle.clear();
        taContent.clear();
        tfDate.clear();
        tfMonth.clear();
        tfYear.clear();
    }
}
