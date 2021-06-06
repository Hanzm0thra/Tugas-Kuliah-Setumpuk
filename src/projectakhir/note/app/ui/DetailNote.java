package projectakhir.note.app.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class DetailNote extends Application {

    private Text textId;
    private Text textTitle;
    private Text textContent;
    private Text textDeadline;
    private Text textDate;
    private Text textMonth;
    private Text textYear;
    private Text textAuthor;

    private Button btnBack;

    private String id;
    private String title;
    private String content;
    private String deadline;
    private String date;
    private String month;
    private String year;
    private String author;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initTextId();
        initTextTitle();
        initTextContent();
        initTextDeadline();
        initTextDate();
        initTextMonth();
        initTextYear();
        initTextAuthor();
        initButtonBack(primaryStage);

        VBox vBoxAuthorAndId = new VBox(5, textAuthor, textId);
        VBox vBoxTitleAndContent = new VBox(15, textTitle, textContent);
        vBoxTitleAndContent.setPrefSize(400, 450);
        VBox vBoxDeadlineComp = new VBox(10, textDate, textMonth, textYear);
        VBox vBoxDeadline = new VBox(25, textDeadline, vBoxDeadlineComp);
        vBoxDeadline.setPrefSize(150, 450);
        HBox hBoxNote = new HBox(50, vBoxTitleAndContent, vBoxDeadline);

        vBoxAuthorAndId.setLayoutY(50);
        vBoxAuthorAndId.setLayoutX(50);

        hBoxNote.setLayoutY(150);
        hBoxNote.setLayoutX(50);

        Group root = new Group(vBoxAuthorAndId, hBoxNote, btnBack);
        Scene scene = new Scene(root, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initTextId() {
        textId = new Text();
        textId.setText("Id: " + id);
        textId.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
    }

    private void initTextTitle() {
        textTitle = new Text();
        textTitle.setText(title);
        textTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 24));
    }

    private void initTextContent() {
        textContent = new Text();
        textContent.setText(content);
        textContent.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextDeadline() {
        textDeadline = new Text();
        textDeadline.setText("Deadline");
        textDeadline.setFont(Font.font("Calibri", FontWeight.BOLD, 20));
    }

    private void initTextDate() {
        textDate = new Text();
        textDate.setText("Date: " + date);
        textDate.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextMonth() {
        textMonth = new Text();
        textMonth.setText("Month: " + month);
        textMonth.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextYear() {
        textYear = new Text();
        textYear.setText("Year: " + year);
        textYear.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextAuthor() {
        textAuthor = new Text();
        textAuthor.setText("Author: " + author);
        textAuthor.setFont(Font.font("Calibri", FontWeight.BOLD, 14));
    }

    private void initButtonBack(Stage stage) {
        btnBack = new Button();
        btnBack.setText("Back");
        btnBack.setLayoutX(25);
        btnBack.setLayoutY(650);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AllNotesForm allNotesForm = new AllNotesForm();
                allNotesForm.start(stage);
            }
        });
    }

    public void setAllProp(String noteId, String noteTitle, String noteContent, String noteDeadline, String noteAuthor) {
        id = noteId;
        title = noteTitle;
        content = noteContent;
        deadline = noteDeadline;
        author = noteAuthor;
        deadlineBreakDown();
    }

    private void deadlineBreakDown() {
        String[] separatedDeadline = deadline.split("-", -1);

        date = separatedDeadline[0];
        month = separatedDeadline[1];
        year = separatedDeadline[2];
    }

}
