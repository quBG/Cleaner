package com.application.pages;

import com.application.tools.ButtonTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.List;

public class PageController {
    private BorderPane workspace;
    private List<Button> modeSelections = new ArrayList<>();

    public void setWorkspace(BorderPane workspace, List<Button> modeSelections) {
        this.workspace = workspace;
        this.modeSelections = modeSelections;
    }

    public void loadPage(String path, ActionEvent event) {
        try {
            AnchorPane loader = FXMLLoader.load(getClass().getResource(path));
            workspace.setCenter(loader);
            pageIsChanging(event);
        }
        catch (IOException e) {
            Logger.getLogger(PageController.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void pageIsChanging(ActionEvent e) {
        Button button = (Button) e.getSource();
        ButtonTools.buttonBacklight(button, modeSelections);
    }
}
