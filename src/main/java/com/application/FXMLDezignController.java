package com.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
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
        try{
            String view = (String) ((Node)e.getSource()).getUserData();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("WorkPages/" + view));
            borderPane.setCenter(loader.load());
        }catch (Exception exception){
            System.out.println(exception);
        }

    }

    private <T> void VboxToList(VBox container, List<T> list) {
            for (Node element : container.getChildren().stream().toList())
                list.add((T)element);
    }
}