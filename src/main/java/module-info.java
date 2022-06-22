module com.cleaner.main.cleaner {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires com.sun.jna;

    opens com.application to javafx.fxml;
    exports com.application.pages;
    exports com.application;
}