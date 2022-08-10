package application.pages;

import javafx.fxml.FXML;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class AboutProgram {
    @FXML
    private void sendToSite(){
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/quBG/Cleaner").toURI());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
