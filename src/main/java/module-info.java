module com.cleaner.main.cleaner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.application to javafx.fxml;
    exports com.application;
}