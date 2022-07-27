package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainApplication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Window window = Window.getInstance(stage, scene);
        window.hideWindowsToTray();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setHeight(565);
        stage.setWidth(825);
        stage.setTitle("ACCleaner");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}