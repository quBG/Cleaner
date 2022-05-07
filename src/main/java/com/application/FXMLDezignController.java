package com.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.*;

public class FXMLDezignController {

    @FXML
    public VBox containerButtons;
    @FXML
    public VBox containerPictures;

    private List<Button> selectingModes = new ArrayList<>();
    private List<ImageView> modePictures = new ArrayList<>();

    @FXML
    public void initialize() {
        VboxToList(containerButtons, selectingModes);
        VboxToList(containerPictures, modePictures);
    }

    private <T> void VboxToList(VBox container, List<T> list) {
            for (Node element : container.getChildren().stream().toList())
                list.add((T)element);
    }
}