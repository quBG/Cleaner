package com.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainApplication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMinHeight(555);
        stage.setMinWidth(899);
        stage.setMaxHeight(556);
        stage.setMaxWidth(900);
        stage.setTitle("Cleaner");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}