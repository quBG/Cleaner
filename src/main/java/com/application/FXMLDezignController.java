package com.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    private <T> void VboxToList(VBox container, List<T> list) {
            for (Node element : container.getChildren().stream().toList())
                list.add((T)element);
    }

    public void SetPage(ActionEvent actionEvent) {

    }
}