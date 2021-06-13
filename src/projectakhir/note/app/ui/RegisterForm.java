package projectakhir.note.app.ui;

import io.reactivex.Observable;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import projectakhir.note.app.core.repository.INoteRepository;
import projectakhir.note.app.di.Injection;


public class RegisterForm extends Application {

    private Text txtRegister;
    private Text txtUsername;
    private Text txtEmail;
    private Text txtPassword;
    private Text txtRePassword;

    private Text txtErrorUsername;
    private Text txtErrorEmail;
    private Text txtErrorPassword;
    private Text txtErrorRePassword;

    private TextField tfUsername;
    private TextField tfEmail;
    private TextField tfPassword;
    private TextField tfRePassword;

    private Button btnRegister;
    private Button btnBack;

    private final INoteRepository noteRepository = Injection.provideNoteRepository;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initTextRegister();
        initTextUsername();
        initTextEmail();
        initTextPassword();
        initTextRePassword();

        initTextErrorUsername();
        initTextErrorEmail();
        initTextErrorPassword();
        initTextErrorRePassword();

        initTextFieldUsername();
        initTextFieldEmail();
        initTextFieldPassword();
        initTextFieldRePassword();

        initButtonRegister(primaryStage);
        initButtonBack(primaryStage);

        VBox vBoxTextComp = new VBox(28, txtUsername, txtEmail, txtPassword, txtRePassword);
        VBox vBoxTextFieldComp = new VBox(20, tfUsername, tfEmail, tfPassword, tfRePassword);
        VBox vBoxErrorComp = new VBox(28, txtErrorUsername, txtErrorEmail, txtErrorPassword, txtErrorRePassword);

        HBox hBoxRegisterFill = new HBox(35, vBoxTextComp, vBoxTextFieldComp, vBoxErrorComp);
        HBox hBoxRegisterButton = new HBox(35, btnRegister);

        VBox vBoxLoginComp = new VBox(20, hBoxRegisterFill, hBoxRegisterButton);
        vBoxLoginComp.setLayoutX(100);
        vBoxLoginComp.setLayoutY(200);

        Group root = new Group(txtRegister, vBoxLoginComp, btnBack);

        Scene scene = new Scene(root, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

        observeCheck();
    }

    private void initTextRegister() {
        txtRegister = new Text();
        txtRegister.setText("Register");
        txtRegister.setLayoutX(350);
        txtRegister.setLayoutY(150);
        txtRegister.setFont(Font.font("Calibri", FontWeight.BOLD, 24));
    }

    private void initTextUsername() {
        txtUsername = new Text();
        txtUsername.setText("Username");
        txtUsername.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextEmail() {
        txtEmail = new Text();
        txtEmail.setText("Email");
        txtEmail.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextPassword() {
        txtPassword = new Text();
        txtPassword.setText("Password");
        txtPassword.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextRePassword() {
        txtRePassword = new Text();
        txtRePassword.setText("Re-Password");
        txtRePassword.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextErrorUsername() {
        txtErrorUsername = new Text();
        txtErrorUsername.setFill(Color.RED);
        txtErrorUsername.setVisible(false);
        txtErrorUsername.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextErrorEmail() {
        txtErrorEmail = new Text();
        txtErrorEmail.setFill(Color.RED);
        txtErrorEmail.setVisible(false);
        txtErrorEmail.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextErrorPassword() {
        txtErrorPassword = new Text();
        txtErrorPassword.setFill(Color.RED);
        txtErrorPassword.setVisible(false);
        txtErrorPassword.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextErrorRePassword() {
        txtErrorRePassword = new Text();
        txtErrorRePassword.setFill(Color.RED);
        txtErrorRePassword.setVisible(false);
        txtErrorRePassword.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextFieldUsername() {
        tfUsername = new TextField();
        if (tfUsername.getText().isEmpty()) {
            txtErrorUsername.setText("Field ini tidak boleh kosong");
            txtErrorUsername.setVisible(true);
        }
    }

    private void initTextFieldEmail() {
        tfEmail = new TextField();
        if (tfEmail.getText().isEmpty()) {
            txtErrorEmail.setText("Field ini tidak boleh kosong");
            txtErrorEmail.setVisible(true);
        }
    }

    private void initTextFieldPassword() {
        tfPassword = new TextField();
        if (tfPassword.getText().isEmpty()) {
            txtErrorPassword.setText("Field ini tidak boleh kosong");
            txtErrorPassword.setVisible(true);
        }
    }

    private void initTextFieldRePassword() {
        tfRePassword = new TextField();
        if (tfRePassword.getText().isEmpty()) {
            txtErrorRePassword.setText("Field ini tidak boleh kosong");
            txtErrorRePassword.setVisible(true);
        }
    }

    private void initButtonRegister(Stage stage) {
        btnRegister = new Button();
        btnRegister.setText("Register");
        btnRegister.setDisable(true);
        btnRegister.setPrefSize(520, 50);
        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = tfUsername.getText();
                String email = tfEmail.getText();
                String password = tfPassword.getText();
                noteRepository.register(email, password, username);
                Dialog<String> dialog = new Dialog<>();
                ButtonType btnOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().add(btnOK);
                dialog.setContentText("Registrasi berhasil, silahkan login");
                dialog.showAndWait();
                LoginForm loginForm = new LoginForm();
                loginForm.start(stage);
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
                LoginForm loginForm = new LoginForm();
                loginForm.start(stage);
            }
        });
    }

    private void observeCheck() {

        tfUsername.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                   Observable.just(newValue)
                           .map(value -> value.isEmpty() || noteRepository.isNameAlreadyExist(value))
                           .subscribe(isNotValid -> showErrorUsername(isNotValid));
            }
        });


        tfEmail.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Observable.just(newValue)
                        .map(value -> value.isEmpty() || noteRepository.isEmailAlreadyExist(value))
                        .subscribe(isNotValid -> showErrorEmail(isNotValid));
            }
        });



        tfPassword.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Observable.just(newValue)
                        .map(value -> value.isEmpty() || !value.equals(tfRePassword.getText()))
                        .subscribe(isNotValid -> showErrorPassword(isNotValid));
            }
        });

        tfRePassword.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                Observable.just(newValue)
                        .map(value -> value.isEmpty() || !value.equals(tfPassword.getText()))
                        .subscribe(isNotValid -> showErrorRePassword(isNotValid));
            }
        });
    }

    private void showErrorUsername(boolean isNotValid) {
        if (tfUsername.getText().isEmpty())
            txtErrorUsername.setText("Field ini tidak boieh kosong");
        else
            txtErrorUsername.setText("Username telah digunakan");
        txtErrorUsername.setVisible(isNotValid);
        checkButtonRegister();
    }

    private void showErrorEmail(boolean isNotValid) {
        if (tfEmail.getText().isEmpty())
            txtErrorEmail.setText("Field ini tidak boleh kosong");
        else
            txtErrorEmail.setText("Email telah digunakan");
        txtErrorEmail.setVisible(isNotValid);
        checkButtonRegister();
    }

    private void showErrorPassword(boolean isNotValid) {
        if (tfPassword.getText().isEmpty()) {
            txtErrorPassword.setText("Field ini tidak boleh kosong");
            txtErrorPassword.setVisible(isNotValid);
        }
        else {
            txtErrorRePassword.setText("Password tidak sama");
            txtErrorRePassword.setVisible(isNotValid);
            txtErrorPassword.setVisible(false);
        }
        checkButtonRegister();
    }

    private void showErrorRePassword(boolean isNotValid) {
        if (tfRePassword.getText().isEmpty())
            txtErrorRePassword.setText("Field ini tidak boleh kosong");
        else
            txtErrorRePassword.setText("Password tidak sama");
        txtErrorRePassword.setVisible(isNotValid);
        checkButtonRegister();
    }

    private void checkButtonRegister() {
        if (txtErrorUsername.isVisible() || txtErrorEmail.isVisible() || txtErrorPassword.isVisible() || txtErrorRePassword.isVisible()) {
            btnRegister.setDisable(true);
        }
        else {
            btnRegister.setDisable(false);
        }
    }
}
