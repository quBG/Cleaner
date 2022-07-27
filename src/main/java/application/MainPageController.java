package application;

import application.exit.Observer;
import application.pages.PageController;
import application.tools.ButtonTools;
import application.tools.ConverterTools;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.*;

public class MainPageController implements Initializable {
    public static BorderPane mainWorkspace;
    @FXML
    private VBox containerButtons;
    @FXML
    private BorderPane workspace;
    private List<Observer> observers = new ArrayList<>();
    private List<Button> modeSelections = new ArrayList<>();
    private PageController pageController = new PageController();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainWorkspace = workspace;
        pageController.setWorkspace(workspace);
        ConverterTools.vboxToList(containerButtons, modeSelections);
        addObserver((Observer) Window.getInstance(null,null));
    }

    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
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
    private void programSettings(ActionEvent event) {
        pageController.loadPage("/application/WorkPages/ProgramSettings.fxml");
        ButtonTools.buttonBacklight((Button) event.getSource(), modeSelections);
    }

    @FXML
    private void closeProgram() {
        for (Observer observer : observers){
            observer.update();
        }
        System.out.println("TOOOOO EXXXXXXIIIIIITTTTTTT");
    }
}
