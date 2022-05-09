package com.application;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.util.*;

public class FXMLDezignController {

    @FXML
    public VBox containerPictures;
    @FXML
    public ListView modeSelection;

    private List<ImageView> modePictures = new ArrayList<>();

    @FXML
    public void initialize() {
        VboxToList(containerPictures, modePictures);

    }

    private <T> void VboxToList(VBox container, List<T> list) {
            for (Node element : container.getChildren().stream().toList())
                list.add((T)element);
    }
}