package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import praktikumpbo10.Data;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("sample.fxml")));

        Text titleText = new Text();
        titleText.setText("Hello");
        titleText.setLayoutX(50);
        titleText.setLayoutY(50);

        Button btnCreate = new Button();
        btnCreate.setLayoutX(100);
        btnCreate.setLayoutY(100);
        btnCreate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    Data.initDosen();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Group root = new Group(titleText, btnCreate);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 200, 200));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
