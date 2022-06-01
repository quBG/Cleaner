package com.application;

import com.application.Tools.ButtonTools;
import com.application.Tools.Converter;
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
        Converter.vboxToList(containerButtons, modeSelections);
        pageController.setWorkspace(workspace, modeSelections);
    }

    public void cleaningFiles(ActionEvent event) {
        pageController.loadPage(getClass().getResource("/com/application/WorkPages/CleaningFiles.fxml"), event);
    }

    public void clearingMemory(ActionEvent event) {
        pageController.loadPage(getClass().getResource("/com/application/WorkPages/ClearingMemory.fxml"), event);
    }

    public void computerInformation(ActionEvent event) {
        pageController.loadPage(getClass().getResource("/com/application/WorkPages/ComputerInformation.fxml"), event);
    }

    public void computerSettings(ActionEvent event) {
        pageController.loadPage(getClass().getResource("/com/application/WorkPages/ComputerSettings.fxml"), event);
    }

    public void programSettings(ActionEvent event) {
        pageController.loadPage(getClass().getResource("/com/application/WorkPages/ProgramSettings.fxml"), event);
    }

    public void closeProgram(){
        Platform.exit();
        System.exit(0);
    }
}