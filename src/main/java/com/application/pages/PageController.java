package com.application.pages;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.net.URL;

public class PageController {
    private BorderPane workspace;

    private void loadPage(URL path){
        try {
            FXMLLoader loader = new FXMLLoader(path);
            workspace.setCenter(loader.load());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void cleaningFiles() {
        loadPage(getClass().getResource("/com/application/WorkPages/CleaningFiles.fxml"));
    }

    public void clearingMemory() {

    }

    public void computerInformation() {

    }

    public void computerSettings() {

    }

    public void programSettings() {

    }

    public void setWorkspace(BorderPane workspace) {
        this.workspace = workspace;
    }
}
