module com.cleaner.main.cleaner {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.logging;
    requires java.desktop;

    opens com.application to javafx.fxml;
    exports com.application.pages;
    exports com.application;
}