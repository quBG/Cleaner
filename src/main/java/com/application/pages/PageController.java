package com.application.pages;

import com.application.Tools.ButtonTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PageController {
    private BorderPane workspace;
    private List<Button> modeSelections = new ArrayList<>();

    public void loadPage(URL path, ActionEvent event){
        try {
            FXMLLoader loader = new FXMLLoader(path);
            workspace.setCenter(loader.load());
            pageIsChanging(event);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private void pageIsChanging(ActionEvent e) {
        Button button = (Button) e.getSource();
        ButtonTools.buttonBacklight(button, modeSelections);
    }

    public void setWorkspace(BorderPane workspace, List<Button> modeSelections) {
        this.workspace = workspace;
        this.modeSelections = modeSelections;
    }
}
