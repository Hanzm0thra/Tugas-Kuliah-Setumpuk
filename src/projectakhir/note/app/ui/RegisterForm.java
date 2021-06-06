package projectakhir.note.app.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

    private Text txtAccountAvailable;

    private TextField tfUsername;
    private TextField tfEmail;
    private TextField tfPassword;
    private TextField tfRePassword;

    private Button btnCheck;
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

        initTextAccountAvailable();

        initTextFieldUsername();
        initTextFieldEmail();
        initTextFieldPassword();
        initTextFieldRePassword();

        initButtonCheck();
        initButtonRegister(primaryStage);
        initButtonBack(primaryStage);

        VBox vBoxTextComp = new VBox(28, txtUsername, txtEmail, txtPassword, txtRePassword);
        VBox vBoxTextFieldComp = new VBox(20, tfUsername, tfEmail, tfPassword, tfRePassword);
        VBox vBoxErrorComp = new VBox(28, txtErrorUsername, txtErrorEmail, txtErrorPassword, txtErrorRePassword);

        HBox hBoxRegisterFill = new HBox(35, vBoxTextComp, vBoxTextFieldComp, vBoxErrorComp);
        HBox hBoxRegisterButton = new HBox(35, btnCheck, btnRegister, txtAccountAvailable);

        VBox vBoxLoginComp = new VBox(20, hBoxRegisterFill, hBoxRegisterButton);
        vBoxLoginComp.setLayoutX(50);
        vBoxLoginComp.setLayoutY(200);

        Group root = new Group(txtRegister, vBoxLoginComp, btnBack);

        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void initTextRegister() {
        txtRegister = new Text();
        txtRegister.setText("Register");
        txtRegister.setLayoutX(150);
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
        txtErrorUsername.setText("Username telah digunakan");
        txtErrorUsername.setFill(Color.RED);
        txtErrorUsername.setVisible(false);
        txtErrorUsername.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextErrorEmail() {
        txtErrorEmail = new Text();
        txtErrorEmail.setText("Email telah digunakan");
        txtErrorEmail.setFill(Color.RED);
        txtErrorEmail.setVisible(false);
        txtErrorEmail.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextErrorPassword() {
        txtErrorPassword = new Text();
        txtErrorPassword.setText("");
    }

    private void initTextErrorRePassword() {
        txtErrorRePassword = new Text();
        txtErrorRePassword.setText("Password tidak sama");
        txtErrorRePassword.setFill(Color.RED);
        txtErrorRePassword.setVisible(false);
        txtErrorRePassword.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextAccountAvailable() {
        txtAccountAvailable = new Text();
        txtAccountAvailable.setText("Akun tersedia, silahkan registrasi");
        txtAccountAvailable.setFill(Color.GREEN);
        txtAccountAvailable.setVisible(false);
        txtAccountAvailable.setFont(Font.font("Calibri", FontPosture.REGULAR, 18));
    }

    private void initTextFieldUsername() {
        tfUsername = new TextField();
        if (tfUsername.isFocused())
            btnRegister.setDisable(true);
    }

    private void initTextFieldEmail() {
        tfEmail = new TextField();
        if (tfEmail.isFocused())
            btnRegister.setDisable(true);
    }

    private void initTextFieldPassword() {
        tfPassword = new TextField();
        if (tfPassword.isFocused())
            btnRegister.setDisable(true);
    }

    private void initTextFieldRePassword() {
        tfRePassword = new TextField();
        if (tfRePassword.isFocused())
            btnRegister.setDisable(true);
    }

    private void initButtonCheck() {
        btnCheck = new Button();
        btnCheck.setText("Check");
        btnCheck.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                check();
            }
        });
    }

    private void initButtonRegister(Stage stage) {
        btnRegister = new Button();
        btnRegister.setText("Register");
        btnRegister.setDisable(true);
        btnRegister.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = tfUsername.getText();
                String email = tfEmail.getText();
                String password = tfPassword.getText();
                check();
                LoginForm loginForm = new LoginForm();
                noteRepository.register(email, password, username);
                loginForm.start(stage);
            }
        });
    }

    private void initButtonBack(Stage stage) {
        btnBack = new Button();
        btnBack.setText("Back");
        btnBack.setLayoutX(25);
        btnBack.setLayoutY(450);
        btnBack.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                LoginForm loginForm = new LoginForm();
                loginForm.start(stage);
            }
        });
    }

    private void check() {
        boolean isUsernameFix = false;
        boolean isEmailFix = false;
        boolean isRePasswordFix = false;

        String username = tfUsername.getText();
        String email = tfEmail.getText();
        String password = tfPassword.getText();
        String rePassword = tfRePassword.getText();

        if (noteRepository.isNameAlreadyExist(username) || username.isEmpty()) {
            txtErrorUsername.setVisible(true);
            txtAccountAvailable.setVisible(false);
        }
        else {
            isUsernameFix = true;
            txtErrorUsername.setVisible(false);
        }


        if (noteRepository.isEmailAlreadyExist(email) || email.isEmpty()) {
            txtAccountAvailable.setVisible(false);
            txtErrorEmail.setVisible(true);
        }
        else {
            isEmailFix = true;
            txtErrorEmail.setVisible(false);
        }


        if (!password.equals(rePassword)) {
            txtAccountAvailable.setVisible(false);
            txtErrorRePassword.setVisible(true);
        }
        else {
            isRePasswordFix = true;
            txtErrorRePassword.setVisible(false);
        }

        if (isUsernameFix && isEmailFix && isRePasswordFix) {
            btnRegister.setDisable(false);
            txtAccountAvailable.setVisible(true);
        }

    }
}
