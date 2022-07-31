package application.pages;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PageController {
    /**
     * Method loads the page in the BorderPane
     * @param workspace used to place an fxml object in it
     * @param path indicated as "/application/PageToFXML/object.fxml"
     */
    public void loadPage(BorderPane workspace, String path) {
        if (workspace == null)
            throw new NullPointerException("workspace is not defined (PageController.java)");

        try {
            AnchorPane loader = FXMLLoader.load(getClass().getResource(path));
            workspace.setCenter(loader);
        }
        catch (IOException e) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
