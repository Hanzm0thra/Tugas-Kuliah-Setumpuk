package praktikumpbo10.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import praktikumpbo10.Data;
import praktikumpbo10.Mahasiswa;

public class FormMahasiswa extends Application {


    Text txtTitle;
    Text txtNIM;
    TextField tfNIM;
    Text txtNama;
    TextField tfNama;
    Text txtProdi;
    TextField tfProdi;
    Text txtFakultas;
    TextField tfFakultas;

    Button btnTambah;
    Button btnUpdate;
    Button btnHapus;
    Button btnReset;
    Button btnBack;

    TableView<Mahasiswa> tableMahasiswa;
    TableColumn<Mahasiswa, String> columnNIP;
    TableColumn<Mahasiswa, String> columnNama;
    TableColumn<Mahasiswa, String> columnProdi;
    TableColumn<Mahasiswa, String> columnFakultas;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        initTextTitle();
        initTextNIM();
        initTextFieldNIM();
        initTextNama();
        initTexFiledNama();
        initTextProdi();
        initTextFieldProdi();
        initTextFakultas();
        initTextFieldFakultas();

        initButtonTambah();
        initButtonUpdate();
        initButtonHapus();
        initButtonReset();
        initButtonBack(primaryStage);
        buttonsNormalCondition();

        initTableView();

        HBox nip = new HBox(47, txtNIM, tfNIM);
        HBox nama = new HBox(33, txtNama, tfNama);
        HBox prodi = new HBox(38, txtProdi, tfProdi);
        HBox fakultas = new HBox(14, txtFakultas, tfFakultas);
        HBox btnCommand = new HBox(10, btnTambah, btnUpdate, btnHapus, btnReset);

        VBox prop = new VBox(25, nip, nama, prodi, fakultas, btnCommand);
        prop.setLayoutX(25);
        prop.setLayoutY(100);

        VBox table = new VBox(0, tableMahasiswa);
        table.setLayoutX(400);
        table.setLayoutY(100);

        Group root = new Group(txtTitle, prop, table, btnBack);

        Scene scene = new Scene(root, 750, 500);
        primaryStage.setScene(scene);
        primaryStage.show();

        tampilData();
    }

    private void initTextTitle() {
        txtTitle = new Text();
        txtTitle.setText("Manajemen Mahasiswa");
        txtTitle.setX(300);
        txtTitle.setY(30);
        txtTitle.setFont(Font.font("Calibri", FontWeight.BOLD, 24));
    }

    private void initTextNIM() {
        txtNIM = new Text();
        txtNIM.setText("NIM");
        txtNIM.setFont(Font.font("Calibri", FontPosture.REGULAR, 20));
    }

    private void initTextFieldNIM() {
        tfNIM = new TextField();
    }

    private void initTextNama() {
        txtNama = new Text();
        txtNama.setText("Nama");
        txtNama.setX(25);
        txtNama.setY(150);
        txtNama.setFont(Font.font("Calibri", FontPosture.REGULAR, 20));
    }

    private void initTexFiledNama() {
        tfNama = new TextField();
    }

    private void initTextProdi() {
        txtProdi = new Text();
        txtProdi.setText("Prodi");
        txtProdi.setFont(Font.font("Calibri", FontPosture.REGULAR, 20));
    }

    private void initTextFieldProdi() {
        tfProdi = new TextField();
    }

    private void initTextFakultas() {
        txtFakultas = new Text();
        txtFakultas.setText("Fakultas");
        txtFakultas.setFont(Font.font("Calibri", FontPosture.REGULAR, 20));
    }

    private void initTextFieldFakultas() {
        tfFakultas = new TextField();
    }

    private void initButtonTambah() {
        btnTambah = new Button();
        btnTambah.setText("Tambah");
        btnTambah.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                tambahData();
            }
        });
    }

    private void initButtonUpdate() {
        btnUpdate = new Button();
        btnUpdate.setText("Update");
        btnUpdate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                updateData();
                buttonsNormalCondition();
            }
        });
    }

    private void initButtonHapus() {
        btnHapus = new Button();
        btnHapus.setText("Hapus");
        btnHapus.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hapusData();
                buttonsNormalCondition();
            }
        });
    }

    private void initButtonReset() {
        btnReset = new Button();
        btnReset.setText("Reset");
        btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                reset();
                buttonsNormalCondition();
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
                Main main = new Main();
                main.start(stage);
            }
        });
    }

    private void initTableView() {
        tableMahasiswa = new TableView<Mahasiswa>();

        tableMahasiswa.setRowFactory(tableView -> {
            TableRow<Mahasiswa> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty()) {
                    Mahasiswa rowData = row.getItem();
                    edit(rowData);
                }
            });
            return row;
        });

        tableMahasiswa.setOnKeyPressed(event -> {
            Mahasiswa rowData = tableMahasiswa.getSelectionModel().getSelectedItem();
            edit(rowData);
        });

        columnNIP = new TableColumn<Mahasiswa, String>();
        columnNIP.setCellValueFactory(new PropertyValueFactory<>("nim"));
        columnNIP.setText("NIM");

        columnNama = new TableColumn<Mahasiswa, String>();
        columnNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        columnNama.setText("Nama");

        columnProdi = new TableColumn<Mahasiswa, String>();
        columnProdi.setCellValueFactory(new PropertyValueFactory<>("prodi"));
        columnProdi.setText("Prodi");

        columnFakultas = new TableColumn<Mahasiswa, String>();
        columnFakultas.setCellValueFactory(new PropertyValueFactory<>("fakultas"));
        columnFakultas.setText("Fakultas");

        tableMahasiswa.getColumns().add(columnNIP);
        tableMahasiswa.getColumns().add(columnNama);
        tableMahasiswa.getColumns().add(columnProdi);
        tableMahasiswa.getColumns().add(columnFakultas);
    }

    public void tampilData() {
        for(Mahasiswa obj: Data.mhs)
            tableMahasiswa.getItems().add(obj);
    }

    public void tambahData() {
        String nip = tfNIM.getText().trim();
        String nama = tfNama.getText().trim();
        String prodi = tfProdi.getText().trim();
        String fakultas = tfFakultas.getText().trim();
        String data = nip + "-" + nama + "-" + prodi + "-" + fakultas;

        if (Data.pecahMhs(data)) {
            Data.simpanMhs();
            tableMahasiswa.getItems().add(new Mahasiswa(nip, nama, prodi, fakultas));
            reset();
        }

        tableMahasiswa.sort();
    }

    public void edit(Mahasiswa mahasiswa) {
        if (mahasiswa != null) {
            tfNIM.setText(mahasiswa.getNim());
            tfNama.setText(mahasiswa.getNama());
            tfProdi.setText(mahasiswa.getProdi());
            tfFakultas.setText(mahasiswa.getFakultas());
            buttonsSelectedRowCondition();
            tfNIM.setStyle("");
        }
    }

    public void updateData() {
        hapusData();
        tambahData();
    }

    public void hapusData() {
        Mahasiswa selected = tableMahasiswa.getSelectionModel().getSelectedItem();
        if (selected != null) {
            tableMahasiswa.getItems().remove(selected);
            Data.hapusMhs(selected.getNim());
        }
    }

    public void reset() {
        tfNIM.setText("");
        tfNama.setText("");
        tfProdi.setText("");
        tfFakultas.setText("");
        tableMahasiswa.getSelectionModel().clearSelection();
    }

    public void buttonsNormalCondition() {
        btnTambah.setDisable(false);
        btnUpdate.setDisable(true);
        btnHapus.setDisable(true);
        btnReset.setDisable(false);
    }

    public void buttonsSelectedRowCondition() {
        btnTambah.setDisable(true);
        btnUpdate.setDisable(false);
        btnHapus.setDisable(false);
        btnReset.setDisable(false);
    }
}
