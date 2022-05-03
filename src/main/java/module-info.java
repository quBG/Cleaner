module com.cleaner.main.cleaner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.cleaner to javafx.fxml;
    exports com.cleaner;
}