package com.cleaner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainApplication extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMinHeight(450);
        stage.setMinWidth(700);
        stage.setMaximized(true);
        stage.setTitle("Cleaner");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}