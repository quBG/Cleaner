package application;

import application.pages.PageController;
import application.tools.ConverterTools;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;

public class MainApplicationController implements Initializable {
    @FXML
    private VBox containerButtons;
    @FXML
    private BorderPane workspace;
    private PageController pageController = new PageController();
    private List<Button> modeSelections = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ConverterTools.vboxToList(containerButtons, modeSelections);
        pageController.setWorkspace(workspace, modeSelections);
    }

    public void cleaningFiles(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/CleaningFiles.fxml", event);
    }

    public void clearingMemory(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/ClearingMemory.fxml", event);
    }

    public void computerInformation(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/ComputerInformation.fxml", event);
    }

    public void computerSettings(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/ComputerSettings.fxml", event);
    }

    public void programSettings(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/ProgramSettings.fxml", event);
    }

    public void closeProgram(){
        Platform.exit();
        System.exit(0);
    }
}