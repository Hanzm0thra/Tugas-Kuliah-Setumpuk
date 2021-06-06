package projectakhir.note.app.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.MapValueFactory;
import javafx.stage.Stage;
import projectakhir.note.app.core.repository.INoteRepository;
import projectakhir.note.app.di.Injection;
import projectakhir.note.app.model.Note;

import java.util.HashMap;
import java.util.Map;

public class AllNotesForm extends Application {

    TableView<Map> noteTable;
    TableColumn<Map, Integer> columnId;
    TableColumn<Map, String> columnTitle;
    TableColumn<Map, String> columnContent;
    TableColumn<Map, String> columnDate;
    TableColumn<Map, String> columnAuthor;

    Button btnBack;

    private final INoteRepository noteRepository = Injection.provideNoteRepository;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initTableView();
        initButtonBack(primaryStage);

        Group root = new Group(noteTable, btnBack);
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initTableView() {
        noteTable = new TableView<>();
        noteTable.setLayoutX(50);
        noteTable.setPrefSize(400, 400);

        columnId = new TableColumn<>();
        columnId.setCellValueFactory(new MapValueFactory<>("id"));
        columnId.setText("Id");

        columnTitle = new TableColumn<>();
        columnTitle.setCellValueFactory(new MapValueFactory<>("title"));
        columnTitle.setText("Title");

        columnContent = new TableColumn<>();
        columnContent.setCellValueFactory(new MapValueFactory<>("content"));
        columnContent.setText("Content");

        columnDate = new TableColumn<>();
        columnDate.setCellValueFactory(new MapValueFactory<>("date"));
        columnDate.setText("Deadline");

        columnAuthor = new TableColumn<>();
        columnAuthor.setCellValueFactory(new MapValueFactory<>("author"));
        columnAuthor.setText("Author");

        noteTable.getColumns().add(columnId);
        noteTable.getColumns().add(columnTitle);
        noteTable.getColumns().add(columnDate);

        showAllNotes();
    }

    private void showAllNotes() {
        ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();

        for (Note note: noteRepository.getAllNotes(HomeForm.argAccountName)) {
            Map<String, Object> item = new HashMap<>();
            item.put("id", note.id());
            item.put("title", note.title());
            item.put("date", note.date());
            items.add(item);
        }
        noteTable.getItems().addAll(items);
    }

    private void initButtonBack(Stage stage) {
        btnBack = new Button();
        btnBack.setText("Back");
        btnBack.setLayoutX(25);
        btnBack.setLayoutY(450);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HomeForm homeForm = new HomeForm();
                homeForm.start(stage);
            }
        });
    }
}
