package com.application;

import com.application.pages.PageController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.effect.Bloom;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.util.*;

public class MainApplicationController {
    @FXML
    private VBox containerButtons;
    @FXML
    private BorderPane workspace;
    private PageController pageController = new PageController();
    private List<Button> modeSelections = new ArrayList<>();

    @FXML
    private void initialize() {
        vboxToList(containerButtons, modeSelections);
        pageController.setWorkspace(workspace);
    }

    private void setPage(ActionEvent e) {
        Button button = (Button) e.getSource();
        buttonBacklight(button);
    }

    public void closeProgram(){
        Platform.exit();
        System.exit(0);
    }

    private void buttonBacklight(Button button){
        clearButtonsEffects(modeSelections);
        button.setEffect(new Bloom(0.9f));
    }

    private void clearButtonsEffects(List<Button> buttons){
        for (Button button : buttons)
            button.setEffect(null);
    }

    private <T> void vboxToList(VBox box, List<T> list) {
        for (Node element : box.getChildren().stream().toList())
            list.add((T)element);
    }

    public void cleaningFiles(ActionEvent actionEvent) {
        pageController.cleaningFiles();
        setPage(actionEvent);
    }

    public void clearingMemory(ActionEvent actionEvent) {
        pageController.clearingMemory();
        setPage(actionEvent);
    }

    public void computerInformation(ActionEvent actionEvent) {
        pageController.computerInformation();
        setPage(actionEvent);
    }

    public void computerSettings(ActionEvent actionEvent) {
        pageController.computerSettings();
        setPage(actionEvent);
    }

    public void programSettings(ActionEvent actionEvent) {
        pageController.programSettings();
        setPage(actionEvent);
    }
}