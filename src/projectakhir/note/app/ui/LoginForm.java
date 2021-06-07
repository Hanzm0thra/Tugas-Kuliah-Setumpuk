package projectakhir.note.app.ui;

import javafx.application.Application;
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
import projectakhir.note.app.model.Login;

public class LoginForm extends Application {

    private Text txtWelcome;
    private Text txtEmail;
    private Text txtPassword;
    private Text txtWarn;

    private TextField tfEmail;
    private TextField tfPassword;

    private Button btnLogin;
    private Button btnRegister;

    private final INoteRepository noteRepository = Injection.provideNoteRepository;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initTextWelcome();
        initTextEmail();
        initTextPassword();
        initTextWarn();

        initTextFieldEmail();
        initTextFieldPassword();

        initButtonLogin(primaryStage);
        initButtonRegister(primaryStage);

        HBox email = new HBox(50, txtEmail, tfEmail);
        HBox password = new HBox(20, txtPassword, tfPassword);
        HBox loginRegister = new HBox(20, btnLogin, btnRegister, txtWarn);

        VBox login = new VBox(25,email, password, loginRegister);
        login.setLayoutX(200);
        login.setLayoutY(265);

        Group root = new Group(txtWelcome, login);
        Scene scene = new Scene(root, 700, 700);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initTextWelcome() {
        txtWelcome = new Text();
        txtWelcome.setText("Welcome To Note");
        txtWelcome.setX(275);
        txtWelcome.setY(200);
        txtWelcome.setFont(Font.font("Calibri", FontWeight.BOLD, 24));
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

    private void initTextFieldEmail() {
        tfEmail = new TextField();
    }

    private void initTextFieldPassword() {
        tfPassword = new TextField();
    }

    private void initButtonLogin(Stage stage) {
        btnLogin = new Button();
        btnLogin.setText("Login");

        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Dialog<String> dialog = new Dialog<>();
                ButtonType btnOK = new ButtonType("OK", ButtonBar.ButtonData.OK_DONE);
                dialog.getDialogPane().getButtonTypes().add(btnOK);

               if (auth().email() == null) {
                   dialog.setContentText("Login gagal, akun tidak tersedia");
                   dialog.showAndWait();
               } else {
                   dialog.setContentText("Login berhasil, selamat datang " + auth().name());
                   dialog.showAndWait();
                   HomeForm.argAccountName = auth().name();
                   HomeForm homeForm = new HomeForm();
                   homeForm.start(stage);
               }
            }
        });
    }

    private void initButtonRegister(Stage stage) {
        btnRegister = new Button();
        btnRegister.setText("Register");
        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RegisterForm registerForm = new RegisterForm();
                registerForm.start(stage);
            }
        });
    }

    private void initTextWarn() {
        txtWarn = new Text();
        txtWarn.setText("Akun tidak tersedia");
        txtWarn.setVisible(false);
        txtWarn.setFill(Color.RED);
        txtWarn.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private Login auth() {
        Login account;
        String email = tfEmail.getText();
        String password = tfPassword.getText();
        account = noteRepository.getAccount(email, password);
        return account;
    }
}
