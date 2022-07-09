module com.cleaner.main.cleaner {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.logging;
    requires java.desktop;

    opens application to javafx.fxml;
    exports application.pages;
    exports application;
}