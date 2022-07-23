package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.TimerTask;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainApplication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Window window = new Window(stage, scene);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setHeight(565);
        stage.setWidth(825);
        stage.setTitle("ACCleaner");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}