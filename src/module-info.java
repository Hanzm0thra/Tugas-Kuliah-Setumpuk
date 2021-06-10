module JavaFX.Projects {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.swt;
    requires javafx.swing;
    requires javafx.base;
    requires junit;
    requires org.junit.jupiter.api;
    requires jnanoid;
    requires io.reactivex.rxjava2;

    opens sample;
    opens praktikumpbo10;
    opens praktikumpbo10.ui;
    opens projectakhir.note.app;
    opens projectakhir.note.app.ui;
    opens projectakhir.note.test;
}