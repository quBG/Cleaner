package com.application;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    private double OffsetX, OffsetY;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainApplication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        WindowDragging(scene, stage);

        stage.initStyle(StageStyle.UNDECORATED);
        stage.setHeight(565);
        stage.setWidth(825);
        stage.setTitle("ACCleaner");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private void WindowDragging(Scene scene, Stage stage){
        scene.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                OffsetX = stage.getX() - event.getScreenX();
                OffsetY = stage.getY() - event.getScreenY();
            }
        });
        scene.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() + OffsetX);
                stage.setY(event.getScreenY() + OffsetY);
            }
        });
    }
}