module com.cleaner.main.cleaner {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.logging;
    requires java.desktop;
    requires java.security.jgss;
    requires jdk.management;

    opens application to javafx.fxml;
    opens application.pages to javafx.fxml;
    exports application.pages;
    exports application;

}