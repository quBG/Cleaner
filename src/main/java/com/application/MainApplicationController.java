package com.application;

import com.application.pages.Page;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;

public class MainApplicationController {
    @FXML
    private VBox containerButtons;
    @FXML
    private BorderPane borderPane;
    private List<Button> modeSelections = new ArrayList<>();

    @FXML
    private void initialize() {
        vboxToList(containerButtons, modeSelections);
    }

    public void setPage(ActionEvent e) {
        String view = (String) ((Node) e.getSource()).getUserData();
        loadFXML(getClass().getResource(view));
        Button button = (Button) e.getSource();
        buttonBacklight(button);
    }

    private void loadFXML(URL path){
        try {
            FXMLLoader loader = new FXMLLoader(path);
            borderPane.setCenter(loader.load());
            String controllerPath = borderPane.getCenter().getUserData().toString();
            loadingSubController(controllerPath);
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private void loadingSubController(String path){
        try {
            Object temp = Class.forName(path);
            if (temp instanceof Page){
                /////
                /////
                /////
                /////
                /////
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private void buttonBacklight(Button button){
        clearButtonsEffects();
        button.setEffect(new Bloom(0.9f));
    }

    private void clearButtonsEffects(){
        for (Button button : modeSelections)
            button.setEffect(null);
    }

    public void closeProgram(ActionEvent e){
        Platform.exit();
        System.exit(0);
    }

    private <T> void vboxToList(VBox container, List<T> list) {
            for (Node element : container.getChildren().stream().toList())
                list.add((T)element);
    }
}