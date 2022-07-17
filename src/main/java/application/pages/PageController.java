package application.pages;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PageController {
    private BorderPane workspace;

    public void setWorkspace(BorderPane workspace) {
        this.workspace = workspace;
    }

    public void loadPage(String path) {
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
