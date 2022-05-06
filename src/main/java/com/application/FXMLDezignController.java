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

    public void Start(ActionEvent actionEvent) {
        VboxToList(containerButtons, selectingModes);
        VboxToList(containerPictures, modePictures);

        for (ImageView ass : modePictures) {
            System.out.println(ass.getX());
        }
    }

    private <T> void VboxToList(VBox container, List<T> list) {
        try {
            for (Node element : container.getChildren().stream().toList())
                list.add((T)element);
        }catch (Exception e) {
            System.out.println(e);
        }

    }
}