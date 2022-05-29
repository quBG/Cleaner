package com.application.pages;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.net.URL;

public class PageController {
    private BorderPane borderPane;

    public PageController(BorderPane pane){
        borderPane = pane;
    }

    private void loadPage(URL path){
        try {
            FXMLLoader loader = new FXMLLoader(path);
            borderPane.setCenter(loader.load());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public void programSettings() {

    }

    public void computerSettings() {

    }

    public void computerInformation() {

    }

    public void clearingMemory() {

    }

    public void cleaningFiles() {

    }
}
