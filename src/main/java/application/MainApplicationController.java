package application;

import application.pages.PageController;
import application.tools.ButtonTools;
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
    public static BorderPane mainWorkspace;
    private List<Button> modeSelections = new ArrayList<>();
    private PageController pageController = new PageController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainWorkspace = workspace;
        pageController.setWorkspace(workspace);
        ConverterTools.vboxToList(containerButtons, modeSelections);
    }

    public static BorderPane getWorkspace(){
        return mainWorkspace;
    }

    @FXML
    private void cleaningFiles(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/CleaningFiles.fxml");
        ButtonTools.buttonBacklight((Button) event.getSource(), modeSelections);
    }

    @FXML
    private void clearingMemory(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/ClearingMemory.fxml");
        ButtonTools.buttonBacklight((Button) event.getSource(), modeSelections);
    }

    @FXML
    private void computerInformation(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/ComputerInformation.fxml");
        ButtonTools.buttonBacklight((Button) event.getSource(), modeSelections);
    }

    @FXML
    private void computerSettings(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/ComputerSettings.fxml");
        ButtonTools.buttonBacklight((Button) event.getSource(), modeSelections);
    }

    @FXML
    private void programSettings(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/ProgramSettings.fxml");
        ButtonTools.buttonBacklight((Button) event.getSource(), modeSelections);
    }

    @FXML
    private void closeProgram(){
        Platform.exit();
        System.exit(0);
    }
}