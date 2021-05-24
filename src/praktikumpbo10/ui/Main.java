package praktikumpbo10.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import praktikumpbo10.Data;

import java.awt.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text title = initTextTitle();
        Button btnMahasiswa = initButtonMahasiswa(primaryStage);
        Button btnDosen = initButtonDosen(primaryStage);
        Button btnExit = initButtonExit(primaryStage);

        Group root = new Group(title, btnDosen, btnMahasiswa, btnExit);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        Data.initDosen();
        Data.initMahasiswa();
    }

    private Text initTextTitle() {
        Text title = new Text();

        title.setX(150);
        title.setY(200);
        title.setText("Manajemen Civitas");
        title.setFont(Font.font(24));

        return title;
    }

    private Button initButtonMahasiswa(Stage stage) {
        Button btnMahasiswa = new Button();

        btnMahasiswa.setText("Mahasiswa");
        btnMahasiswa.setFont(Font.font(18));
        btnMahasiswa.setLayoutX(100);
        btnMahasiswa.setLayoutY(225);

        btnMahasiswa.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FormMahasiswa fm = new FormMahasiswa();
                fm.start(stage);
            }
        });

        return btnMahasiswa;
    }

    private Button initButtonDosen(Stage stage) {
        Button btnDosen = new Button();

        btnDosen.setText("Dosen");
        btnDosen.setFont(Font.font(18));
        btnDosen.setLayoutX(300);
        btnDosen.setLayoutY(225);

        btnDosen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FormDosen fd = new FormDosen();
                fd.start(stage);
            }
        });

        return btnDosen;
    }

    private Button initButtonExit(Stage stage) {
        Button btnExit = new Button();
        btnExit.setText("Exit");
        btnExit.setFont(Font.font(14));
        btnExit.setLayoutX(25);
        btnExit.setLayoutY(450);

        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                stage.close();
            }
        });

        return btnExit;
    }
}
