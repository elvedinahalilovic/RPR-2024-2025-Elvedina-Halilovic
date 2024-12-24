module com.example.zadatak2lv08 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.xml;

    opens com.example.zadatak2lv08 to javafx.fxml;
    exports com.example.zadatak2lv08;
}