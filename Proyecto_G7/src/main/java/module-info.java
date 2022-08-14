module com.mycompany.poroyecto_prueba {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.poroyecto_prueba to javafx.fxml;
    exports com.mycompany.poroyecto_prueba;
}
