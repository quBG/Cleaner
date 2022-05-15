package com.application;

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

public class FXMLDezignController {

    @FXML
    private VBox containerButtons;
    @FXML
    private BorderPane borderPane;

    private List<Button> modeSelections = new ArrayList<>();

    @FXML
    public void initialize() {
        VboxToList(containerButtons, modeSelections);
    }

    public void SetPage(ActionEvent e) {
        String view = (String) ((Node) e.getSource()).getUserData();
        loadFXML(getClass().getResource(view));
        Button button = (Button) e.getSource();
        ButtonBacklight(button);
    }

    private void loadFXML(URL path){
        try {
            FXMLLoader loader = new FXMLLoader(path);
            borderPane.setCenter(loader.load());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    private void ButtonBacklight(Button button){
        ButtonClening();
        button.setEffect(new Bloom());
    }

    private void ButtonClening(){
        for (Button button : modeSelections) {
            button.setEffect(null);
        }
    }


    private <T> void VboxToList(VBox container, List<T> list) {
            for (Node element : container.getChildren().stream().toList())
                list.add((T)element);
    }
}