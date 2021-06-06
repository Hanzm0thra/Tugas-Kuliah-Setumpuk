package projectakhir.note.app.ui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.MapValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import projectakhir.note.app.core.repository.INoteRepository;
import projectakhir.note.app.di.Injection;
import projectakhir.note.app.model.Note;

import java.util.HashMap;
import java.util.Map;

public class AllNotesForm extends Application {

    private TableView<Map> noteTable;
    private TableColumn<Map, Integer> columnId;
    private TableColumn<Map, String> columnTitle;
    private TableColumn<Map, String> columnDate;

    private Button btnBack;
    private Button btnEdit;
    private Button btnDelete;
    private Button btnDetail;

    private Integer noteId;
    private String noteTitle;
    private String noteContent;
    private String noteDeadline;
    private String noteAuthor;

    private final INoteRepository noteRepository = Injection.provideNoteRepository;
    ObservableList<Map<String, Object>> items = FXCollections.<Map<String, Object>>observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initTableView();
        initButtonBack(primaryStage);
        initButtonEdit(primaryStage);
        initButtonDelete();
        initButtonDetail();

        VBox vBoxButtons = new VBox(25, btnEdit, btnDelete, btnDetail);
        HBox hBoxComp = new HBox(50, noteTable, vBoxButtons);
        hBoxComp.setLayoutX(50);
        hBoxComp.setLayoutY(50);

        Group root = new Group(btnBack, hBoxComp);
        Scene scene = new Scene(root, 700, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initTableView() {
        noteTable = new TableView<>();
        noteTable.setLayoutX(50);
        noteTable.setPrefSize(400, 400);

        noteTable.setRowFactory(table -> {
            TableRow<Map> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Map rowData = row.getItem();
                    selectedRow(rowData);
                }
            });
            return row;
        });

        columnId = new TableColumn<Map, Integer>();
        columnId.setCellValueFactory(new MapValueFactory<Integer>("id"));
        columnId.setText("Id");
        columnId.setPrefWidth(50);

        columnTitle = new TableColumn<>();
        columnTitle.setCellValueFactory(new MapValueFactory<>("title"));
        columnTitle.setText("Title");
        columnTitle.setPrefWidth(220);

        columnDate = new TableColumn<>();
        columnDate.setCellValueFactory(new MapValueFactory<>("date"));
        columnDate.setText("Deadline");
        columnDate.setPrefWidth(130);

        noteTable.getColumns().add(columnId);
        noteTable.getColumns().add(columnTitle);
        noteTable.getColumns().add(columnDate);

        showAllNotes();
    }

    private void showAllNotes() {

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
        btnBack.setLayoutY(550);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HomeForm homeForm = new HomeForm();
                homeForm.start(stage);
            }
        });
    }

    private void initButtonEdit(Stage stage) {
        btnEdit = new Button();
        btnEdit.setText("Edit");
        btnEdit.setPrefSize(100, 50);
        btnEdit.setDisable(true);
        btnEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UpdateNoteForm updateNoteForm = new UpdateNoteForm();
                updateNoteForm.start(stage);
                updateNoteForm.setAllProp(noteId, noteTitle, noteContent, noteDeadline, noteAuthor);
            }
        });
    }

    private void initButtonDelete() {
        btnDelete = new Button();
        btnDelete.setText("Delete");
        btnDelete.setPrefSize(100, 50);
        btnDelete.setDisable(true);
        btnDelete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                noteRepository.delete(noteId);
                Map<String, Object> item = new HashMap<>();
                item.put("id", noteId);
                item.put("title", noteTitle);
                item.put("date", noteDeadline);
                noteTable.getItems().remove(item);
            }
        });
    }

    private void initButtonDetail() {
        btnDetail = new Button();
        btnDetail.setText("Detail");
        btnDetail.setPrefSize(100, 50);
        btnDetail.setDisable(true);
        btnDetail.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

            }
        });
    }

    private void selectedRow(Map note) {
        Integer id = (Integer) note.get("id");
        Note selectedNote = noteRepository.getSelectedNote(id);
        noteId = selectedNote.id();
        noteTitle = selectedNote.title();
        noteContent = selectedNote.content();
        noteDeadline = selectedNote.date();
        noteAuthor = selectedNote.author();

        btnEdit.setDisable(false);
        btnDelete.setDisable(false);
        btnDetail.setDisable(false);
    }
}
