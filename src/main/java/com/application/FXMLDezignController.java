package com.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
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

    private <T> void VboxToList(VBox container, List<T> list) {
            for (Node element : container.getChildren().stream().toList())
                list.add((T)element);
    }

    public void SetPage(ActionEvent e) {
        String view = (String) ((Node)e.getSource()).getUserData();
        loadFXML(getClass().getResource(view));
    }

    private void loadFXML(URL url) {
        try {
            FXMLLoader loader = new FXMLLoader(url);
            borderPane.setCenter(loader.load());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}